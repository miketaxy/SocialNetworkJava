package org.miketaxy.SocialNetwork.service.security.service;

import lombok.RequiredArgsConstructor;
import org.miketaxy.SocialNetwork.model.chat.ChatMessage;
import org.miketaxy.SocialNetwork.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    public void sendMessage(ChatMessage chatMessage) {
        messageRepository.save(chatMessage);
    }

    public List<ChatMessage> getMessages(){
        return messageRepository.findAll();
    }
}
