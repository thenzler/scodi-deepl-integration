package com.scodi.translation.service;

import com.deepl.api.Translator;
import com.deepl.api.TextResult;
import com.deepl.api.DeepLException;
import com.scodi.translation.config.TranslatorConfiguration;
import com.scodi.translation.exception.ConfigurationException;
import com.scodi.translation.exception.TranslationException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

@Service
public class DeepLTranslationService implements TranslationService {
    private final TranslatorConfiguration config;
    private Translator translator;

    public DeepLTranslationService(TranslatorConfiguration config) {
        this.config = config;
    }

    @PostConstruct
    public void initialize() {
        if (isConfigured()) {
            this.translator = new Translator(config.getApiKey());
        }
    }

    @Override
    public String translate(String text, String sourceLanguage, String targetLanguage) 
            throws TranslationException {
        validateConfiguration();
        try {
            TextResult result = translator.translateText(
                text,
                sourceLanguage,
                targetLanguage
            );
            return result.getText();
        } catch (DeepLException | InterruptedException e) {
            throw new TranslationException("Translation failed", e);
        }
    }

    @Override
    public boolean isConfigured() {
        return config != null && StringUtils.hasText(config.getApiKey());
    }

    @Override
    public void validateConfiguration() throws ConfigurationException {
        if (!isConfigured()) {
            throw new ConfigurationException("DeepL API key not configured");
        }
    }
}