package com.lldprojects.splitwise.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDto {
    private Long id;
    private String newPassword;
}
