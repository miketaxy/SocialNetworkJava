package org.miketaxy.SocialNetwork.DTO.securityDTO;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class RegistrationUserDTO {
    private String username;
    private String password;
    private String email;
}
