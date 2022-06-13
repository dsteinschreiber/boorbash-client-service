package com.boorbash.boorbashclientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class BoorbashClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoorbashClientServiceApplication.class, args);
    }


    // To bypass CORS:
    @Bean
    public WebMvcConfigurer configurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .exposedHeaders(
                                "Access-Control-Allow-Origin",
                                "Access-Control-Allow-Methods",
                                "Access-Control-Allow-Headers",
                                "Access-Control-Max-Age",
                                "Access-Control-Request-Headers",
                                "Access-Control-Request-Method"
                        );
            }
        };
    }
}
