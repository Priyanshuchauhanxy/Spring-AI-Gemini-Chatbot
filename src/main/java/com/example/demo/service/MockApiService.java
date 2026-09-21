package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MockApiService {
    private final WebClient webClient;

    public MockApiService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<String> getUsers() {
        return webClient.get()
                .uri("/users")
                .retrieve()
                .bodyToMono(String.class);
    }
}
