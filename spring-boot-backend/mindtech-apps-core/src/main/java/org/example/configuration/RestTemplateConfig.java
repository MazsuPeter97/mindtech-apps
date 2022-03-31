package org.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for RestTemplate.
 */
@Configuration
public class RestTemplateConfig {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
