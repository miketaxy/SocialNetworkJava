package org.miketaxy.SocialNetwork.controller;


import lombok.RequiredArgsConstructor;
import org.miketaxy.SocialNetwork.model.chat.ChatMessage;
import org.miketaxy.SocialNetwork.service.security.service.MessageService;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {
    private final MessageService messageService;
    private final SimpMessagingTemplate brokerMessagingTemplate;
    // TODO: @SendTo
    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessage chatMessage, @Header("simpSessionId") String sessionId) {
        chatMessage.setSender(sessionId);
        messageService.sendMessage(chatMessage);
        brokerMessagingTemplate.convertAndSend("/topic/public", chatMessage);
    }
    // TODO: not working
//    @MessageMapping("/chat.getMessages")
//    @SendToUser("/topic/public")
//    public Iterable<ChatMessage> getMessages(@Header("simpSessionId") String sessionId) {
//        brokerMessagingTemplate.convertAndSend("/user/"+sessionId+"/public", messageService.getMessages());
//        return messageService.getMessages();
//    }
    @GetMapping("/chat.getMessages")
    public Iterable<ChatMessage> getMessages() {
        return messageService.getMessages();
    }
}


