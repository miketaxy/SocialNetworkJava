package org.miketaxy.SocialNetwork.model.chat;

import lombok.*;
import org.miketaxy.SocialNetwork.model.constant.MessageStatus;
import org.miketaxy.SocialNetwork.model.constant.MessageType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.*;
import java.util.Date;
import java.util.List;


@Document(collection = "ChatMessage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatMessage {

    private String content;
    private String sender;
    private MessageType type;

}
