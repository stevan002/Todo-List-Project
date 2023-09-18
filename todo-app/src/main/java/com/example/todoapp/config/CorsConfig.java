package com.example.todoapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000") // Dodajte odgovarajući origin (adresu) vaše React aplikacije
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Definišite dozvoljene HTTP metode
                .allowCredentials(true); // Omogućite razmenu kredencijala (npr. kolačića)
    }
}
