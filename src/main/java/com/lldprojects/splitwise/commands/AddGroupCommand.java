package com.lldprojects.splitwise.commands;

import com.lldprojects.splitwise.Dtos.AddGroupRequestDto;
import com.lldprojects.splitwise.Dtos.AddGroupResponseDto;
import com.lldprojects.splitwise.constants.CommandRegistryConstant;
import com.lldprojects.splitwise.controllers.GroupController;
import org.springframework.beans.factory.annotation.Autowired;

public class AddGroupCommand implements Command{

    @Autowired
    GroupController groupController;

    @Override
    public boolean parseCommand(String command) {
        String[] tokens = command.trim().split("\\s+");
        if (!tokens[1].equals(CommandRegistryConstant.ADD_GROUP) || tokens.length != 3) {
            System.out.println("Invalid command format. Usage: <userId> AddGroup <groupName>");
            return false;
        }
        return true;
    }

    @Override
    public void executeCommand(String command) {
        String[] tokens = command.trim().split("\\s+");
        Long createdById = Long.valueOf(tokens[0]);
        String groupName = tokens[2];

        AddGroupRequestDto requestDto = new AddGroupRequestDto();
        requestDto.setGroupName(groupName);
        requestDto.setCreatedById(createdById);

        AddGroupResponseDto responseDto = groupController.addGroup(requestDto);
        System.out.println("Group created " + responseDto.getGroup().toString());
    }
}
