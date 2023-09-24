package org.miketaxy.SocialNetwork.controller.securityController;

import lombok.RequiredArgsConstructor;
import org.miketaxy.SocialNetwork.DTO.securityDTO.JwtRequest;
import org.miketaxy.SocialNetwork.DTO.securityDTO.JwtResponse;
import org.miketaxy.SocialNetwork.DTO.securityDTO.RegistrationUserDTO;
import org.miketaxy.SocialNetwork.service.security.AuthenticationService;
import org.miketaxy.SocialNetwork.util.security.JwtTokenUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService service;
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthenticationManager manager;


    @PostMapping("/auth")
    public ResponseEntity<JwtResponse> createAuthToken(@RequestBody JwtRequest request) {
        return ResponseEntity.ok(service.authentication(request));
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@RequestBody RegistrationUserDTO register){
        return ResponseEntity.ok(service.register(register));
    }



}
