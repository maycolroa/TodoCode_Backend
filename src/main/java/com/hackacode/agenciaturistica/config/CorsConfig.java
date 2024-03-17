package com.hackacode.agenciaturistica.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*") // Permitir solicitudes desde todos los dominios
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Permitir los métodos HTTP
                        .allowedHeaders("*"); // Permitir todos los encabezados
            }
        };
    }
}
