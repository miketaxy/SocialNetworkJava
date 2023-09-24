package org.miketaxy.SocialNetwork.controller;


import lombok.RequiredArgsConstructor;
import org.miketaxy.SocialNetwork.model.chat.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class MainController {

    @GetMapping
    public String userData(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/admin")
    public String adminData() {
        return "Admin data";
    }

}


