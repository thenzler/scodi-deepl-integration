package com.scodi.translation.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "scodi.translation.deepl")
public class TranslatorConfiguration {
    private String apiKey;
    private int timeout = 30;
    private boolean enabled = false;
}