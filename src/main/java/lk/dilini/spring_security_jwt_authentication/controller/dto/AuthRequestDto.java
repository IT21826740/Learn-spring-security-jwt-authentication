package lk.dilini.spring_security_jwt_authentication.controller.dto;

import lombok.Data;

@Data
public class AuthRequestDto {
    private String username;
    private String password;
}
