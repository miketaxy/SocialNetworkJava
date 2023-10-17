package org.miketaxy.SocialNetwork.repository;

import org.miketaxy.SocialNetwork.model.chat.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<ChatMessage, String> {
}
