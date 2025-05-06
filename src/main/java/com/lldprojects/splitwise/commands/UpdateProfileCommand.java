package com.lldprojects.splitwise.commands;

import com.lldprojects.splitwise.constants.CommandRegistryConstant;

public class UpdateProfileCommand implements Command{
    @Override
    public boolean parseCommand(String command) {
        String[] tokens = command.trim().split("\\s+");
        if (tokens.length != 3 || !tokens[1].equals(CommandRegistryConstant.UPDATE_USER)) {
            System.out.println("Invalid command format. Usage: <userId> UpdateProfile <newPassword>");
            return false;
        }
        String userId = tokens[0];
        String newPassword = tokens[2];
        return true;
    }

    @Override
    public void executeCommand(String command) {

    }
}
