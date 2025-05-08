package com.lldprojects.splitwise.commands;

import com.lldprojects.splitwise.Dtos.UpdateUserRequestDto;
import com.lldprojects.splitwise.Dtos.UpdateUserResponseDto;
import com.lldprojects.splitwise.constants.CommandRegistryConstant;
import com.lldprojects.splitwise.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserCommand implements Command{

    @Autowired
    UserController userController;

    @Override
    public boolean parseCommand(String command) {
        String[] tokens = command.trim().split("\\s+");
        if (tokens.length != 3 || !tokens[1].equals(CommandRegistryConstant.UPDATE_USER)) {
            System.out.println("Invalid command format. Usage: <userId> UpdateProfile <newPassword>");
            return false;
        }
        return true;
    }

    @Override
    public void executeCommand(String command) {
        String[] tokens = command.trim().split("\\s+");
        Long userId = Long.valueOf(tokens[0]);
        String newPassword = tokens[2];

        UpdateUserRequestDto request = new UpdateUserRequestDto();
        request.setId(userId);
        request.setNewPassword(newPassword);

        UpdateUserResponseDto response = userController.updateUser(request);
    }
}
