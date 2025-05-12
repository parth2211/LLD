package com.lldprojects.splitwise.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddGroupMemberRequestDto {
    private Long groupAdminId;
    private Long groupId;
    private Long userId;
}
