package com.scodi.translation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.scodi.translation.service.TranslationService;

@Component
public class TestTranslation implements CommandLineRunner {

    @Autowired
    private TranslationService translationService;

    @Override
    public void run(String... args) throws Exception {
        if (translationService.isConfigured()) {
            String translated = translationService.translate("Hello World", "EN", "DE");
            System.out.println("Translated text: " + translated);
        } else {
            System.out.println("Translation service not configured!");
        }
    }
}