package com.cdeh.msa.rickandmorty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigurationRestTemplate {
    @Bean("RestTemplateConfig")
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
