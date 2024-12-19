package com.scodi.translation.service;

import com.scodi.translation.exception.ConfigurationException;
import com.scodi.translation.exception.TranslationException;

public interface TranslationService {
    String translate(String text, String sourceLanguage, String targetLanguage) throws TranslationException;
    boolean isConfigured();
    void validateConfiguration() throws ConfigurationException;
}