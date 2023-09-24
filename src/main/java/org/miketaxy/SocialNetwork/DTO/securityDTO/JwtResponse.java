package org.miketaxy.SocialNetwork.DTO.securityDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
@Data
@AllArgsConstructor
@Builder
public class JwtResponse {
    private String token;
}
