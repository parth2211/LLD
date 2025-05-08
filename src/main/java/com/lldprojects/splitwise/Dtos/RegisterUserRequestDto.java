package com.lldprojects.splitwise.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    private String username;
    private String phoneNumber;
    private String password;
}
