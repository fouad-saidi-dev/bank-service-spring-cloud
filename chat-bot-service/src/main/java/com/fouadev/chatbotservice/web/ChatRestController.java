package com.fouadev.chatbotservice.web;

import com.fouadev.chatbotservice.services.ChatBotService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 Created by : Fouad SAIDI on 30/11/2024
 @author : Fouad SAIDI
 @date : 30/11/2024
 @project : bank-service-spring-cloud
*/
@RestController
@RequestMapping("/chat")
public class ChatRestController {

    private ChatBotService chatBotService;

    public ChatRestController(ChatBotService chatBotService) {
        this.chatBotService = chatBotService;
    }

    @RequestMapping("/ask")
    public String chat(String qst) {
        return chatBotService.sendMessage(qst);
    }
}