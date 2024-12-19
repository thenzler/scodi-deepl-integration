package com.scodi.translation.service;

import com.scodi.translation.config.TranslatorConfiguration;
import com.scodi.translation.exception.ConfigurationException;
import com.scodi.translation.exception.TranslationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DeepLTranslationServiceTest {

    @Mock
    private TranslatorConfiguration config;

    private DeepLTranslationService translationService;

    @BeforeEach
    void setUp() {
        translationService = new DeepLTranslationService(config);
    }

    @Test
    void testIsConfigured_WithValidApiKey() {
        when(config.getApiKey()).thenReturn("valid-api-key");
        assertTrue(translationService.isConfigured());
    }

    @Test
    void testIsConfigured_WithNoApiKey() {
        when(config.getApiKey()).thenReturn(null);
        assertFalse(translationService.isConfigured());
    }

    @Test
    void testValidateConfiguration_WithValidConfig() {
        when(config.getApiKey()).thenReturn("valid-api-key");
        assertDoesNotThrow(() -> translationService.validateConfiguration());
    }

    @Test
    void testValidateConfiguration_WithInvalidConfig() {
        when(config.getApiKey()).thenReturn(null);
        assertThrows(ConfigurationException.class, () -> translationService.validateConfiguration());
    }
}