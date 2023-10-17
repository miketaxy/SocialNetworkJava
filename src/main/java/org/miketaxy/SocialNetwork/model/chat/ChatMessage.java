package org.miketaxy.SocialNetwork.model.chat;

import lombok.*;
import org.miketaxy.SocialNetwork.model.constant.MessageType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "ChatMessage")
@Data
public class ChatMessage {
    @Id
    private String id;
    private String content;
    private String sender;
//    private MessageType type;

}
