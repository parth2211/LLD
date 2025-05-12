package com.lldprojects.splitwise.controllers;

import com.lldprojects.splitwise.Dtos.AddGroupMemberRequestDto;
import com.lldprojects.splitwise.Dtos.AddGroupMemberResponseDto;
import com.lldprojects.splitwise.Dtos.AddGroupRequestDto;
import com.lldprojects.splitwise.Dtos.AddGroupResponseDto;
import com.lldprojects.splitwise.models.Group;
import com.lldprojects.splitwise.models.User;
import com.lldprojects.splitwise.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GroupController {

    @Autowired
    GroupService groupService;

    public AddGroupResponseDto addGroup(AddGroupRequestDto requestDto) {
        Long createdById = requestDto.getCreatedById();
        String groupName = requestDto.getGroupName();

        Group group = groupService.addGroup(createdById, groupName);

        AddGroupResponseDto responseDto = new AddGroupResponseDto();
        responseDto.setGroup(group);
        return responseDto;
    }

    public AddGroupMemberResponseDto addGroupMember(AddGroupMemberRequestDto requestDto) {
        Long groupAdminId = requestDto.getGroupAdminId();
        Long groupId = requestDto.getGroupId();
        Long userId = requestDto.getUserId();

        Group group = groupService.addGroupMember(groupAdminId, groupId, userId);

        AddGroupMemberResponseDto responseDto = new AddGroupMemberResponseDto();
        responseDto.setGroup(group);
        return responseDto;
    }
}
