package com.fouadev.chatbotservice.services;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

/*
 Created by : Fouad SAIDI on 30/11/2024
 @author : Fouad SAIDI
 @date : 30/11/2024
 @project : bank-service-spring-cloud
*/
@Service
public class ChatBotService {
    private ChatClient chatClient;

    public ChatBotService(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    public String sendMessage(String qst) {
        return chatClient.prompt()
                .user(qst)
                .call()
                .content();
    }
}