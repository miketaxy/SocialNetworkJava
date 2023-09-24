package org.miketaxy.SocialNetwork.service.security;

import lombok.RequiredArgsConstructor;
import org.miketaxy.SocialNetwork.DTO.securityDTO.JwtRequest;
import org.miketaxy.SocialNetwork.DTO.securityDTO.JwtResponse;
import org.miketaxy.SocialNetwork.DTO.securityDTO.RegistrationUserDTO;
import org.miketaxy.SocialNetwork.model.security.User;
import org.miketaxy.SocialNetwork.model.constant.Role;
import org.miketaxy.SocialNetwork.repository.security.UserRepository;
import org.miketaxy.SocialNetwork.util.security.JwtTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenUtil jwtTokenUtil;

    private final AuthenticationManager authenticationManager;

    public JwtResponse register(RegistrationUserDTO register){
        var user = User.builder()
                .username(register.getUsername())
                .password(passwordEncoder.encode(register.getPassword()))
                .email(register.getEmail())
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtTokenUtil.generateToken(user);
        return JwtResponse.builder().token(jwtToken).build();
    }

    public JwtResponse authentication(JwtRequest request){
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );
        } catch (Exception e) {
            throw new RuntimeException("Invalid username or password");
        }
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken = jwtTokenUtil.generateToken(user);
        return JwtResponse.builder().token(jwtToken).build();
    }

}
