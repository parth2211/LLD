package com.lldprojects.splitwise.Dtos;

import com.lldprojects.splitwise.models.Group;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddGroupMemberResponseDto {
    private Group group;

    @Override
    public String toString() {
        return "AddGroupMemberResponseDto{" +
                "group=" + group +
                '}';
    }
}
