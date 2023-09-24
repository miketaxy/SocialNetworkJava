package org.miketaxy.SocialNetwork.repository.security;

import org.miketaxy.SocialNetwork.model.security.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByUsername(String name);
}
