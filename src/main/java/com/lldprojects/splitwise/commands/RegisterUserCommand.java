package com.lldprojects.splitwise.commands;

import com.lldprojects.splitwise.Dtos.RegisterUserRequestDto;
import com.lldprojects.splitwise.Dtos.RegisterUserResponseDto;
import com.lldprojects.splitwise.constants.CommandRegistryConstant;
import com.lldprojects.splitwise.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserCommand implements Command{

    @Autowired
    UserController userController;

    @Override
    public boolean parseCommand(String command) {
        String[] tokens = command.trim().split("\\s+");
        if (tokens.length != 4 || !tokens[0].equals(CommandRegistryConstant.REGISTER_USER)) {
            System.out.println("Invalid command format. Usage: Register <username> <phonenumber> <password>");
            return false;
        }
        return true;
    }

    @Override
    public void executeCommand(String command) {
        String[] tokens = command.trim().split("\\s+");
        String username = tokens[1];
        String phoneNumber = tokens[2];
        String password = tokens[3];

        RegisterUserRequestDto registerUserRequestDto = new RegisterUserRequestDto();
        registerUserRequestDto.setUsername(username);
        registerUserRequestDto.setPhoneNumber(phoneNumber);
        registerUserRequestDto.setPassword(password);

        RegisterUserResponseDto response = userController.registerUser(registerUserRequestDto);
        System.out.println("Registered User " + response.getUser());
    }
}
