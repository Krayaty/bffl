package org.bffl.iamConnector.iamConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class KeycloakWebConfig{

    private final String[] allowedOrigins = {"http://localhost:4200", "https://auth.bfflshort.de"};
    private final long maxAge = 3600;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(final CorsRegistry registry) {
                registry.addMapping("/api/*")
                        .allowedOrigins(KeycloakWebConfig.this.allowedOrigins)
                        .maxAge(KeycloakWebConfig.this.maxAge);
            }
        };
    }

}
