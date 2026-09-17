package com.example.demo.controller;

import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.ai.model.google.genai.autoconfigure.image.GoogleGenAiImageAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
	
	
	private final GoogleGenAiChatModel chatModel; 
	
	public ChatController (GoogleGenAiChatModel chatModel) {
		this.chatModel=chatModel;
	}
   
	@RequestMapping("/chat")
	public String chat (@RequestParam String message) {
		
		return  chatModel.call(message);
	}

}


