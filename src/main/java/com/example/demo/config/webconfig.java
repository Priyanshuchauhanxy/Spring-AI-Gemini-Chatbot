package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class webconfig {

    @Bean
    public WebClient webClient() {

        return WebClient.builder().baseUrl("https://6aabd394ea0e22daa6dca5f1.mockapi.io/").build();

    }

}
