package com.lldprojects.splitwise.commands;

import com.lldprojects.splitwise.Dtos.AddGroupMemberRequestDto;
import com.lldprojects.splitwise.Dtos.AddGroupMemberResponseDto;
import com.lldprojects.splitwise.Dtos.AddGroupRequestDto;
import com.lldprojects.splitwise.Dtos.AddGroupResponseDto;
import com.lldprojects.splitwise.constants.CommandRegistryConstant;
import com.lldprojects.splitwise.controllers.GroupController;
import org.springframework.beans.factory.annotation.Autowired;

public class AddMemberCommand implements Command{

    @Autowired
    GroupController groupController;

    @Override
    public boolean parseCommand(String command) {
        //u1 AddMember g1 u2
        String[] tokens = command.trim().split("\\s+");
        if (!tokens[1].equals(CommandRegistryConstant.ADD_MEMBER_IN_GROUP) || tokens.length != 4) {
            System.out.println("Invalid command format. Usage: <groupAdminId> AddMember <groupId> <userId>");
            return false;
        }
        return true;
    }

    @Override
    public void executeCommand(String command) {
        String[] tokens = command.trim().split("\\s+");
        Long groupAdminId = Long.valueOf(tokens[0]);
        Long groupId = Long.valueOf(tokens[2]);
        Long userId = Long.valueOf(tokens[3]);

        AddGroupMemberRequestDto requestDto = new AddGroupMemberRequestDto();
        requestDto.setGroupAdminId(groupAdminId);
        requestDto.setGroupId(groupId);
        requestDto.setUserId(userId);

        AddGroupMemberResponseDto responseDto = groupController.addGroupMember(requestDto);
        System.out.println("Group member added " + responseDto.getGroup().toString());
    }
}
