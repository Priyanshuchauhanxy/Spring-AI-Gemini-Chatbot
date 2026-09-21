package com.example.demo.controller;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MockApiService;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
public class ChatController {

	private final ChatModel chatModel;
	private final MockApiService mockApiService;

	public ChatController(ChatModel chatModel,
			MockApiService mockApiService) {

		this.chatModel = chatModel;
		this.mockApiService = mockApiService;
	}

	@GetMapping("/chat")
	public Mono<String> chat(@RequestParam String message) {

		return mockApiService.getUsers()
				.publishOn(Schedulers.boundedElastic())
				.map(users -> {
					String prompt = """
							You are a helpful chatbot.

							Here is data fetched from a mock API:

							%s

							User question:
							%s

							Answer the user's question using the API data.
							If the information is not present in the API data, say that
							the information is not available.
							""".formatted(users, message);

					return chatModel.call(prompt);
				});
	}
}