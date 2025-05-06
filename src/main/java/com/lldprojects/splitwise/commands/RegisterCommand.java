package com.lldprojects.splitwise.commands;

import com.lldprojects.splitwise.constants.CommandRegistryConstant;

public class RegisterCommand implements Command{
    @Override
    public boolean parseCommand(String command) {
        String[] tokens = command.trim().split("\\s+");
        if (tokens.length != 4 || !tokens[0].equals(CommandRegistryConstant.REGISTER_USER)) {
            System.out.println("Invalid command format. Usage: Register <username> <phonenumber> <password>");
            return false;
        }
        String username = tokens[1];
        String phoneNumber = tokens[2];
        String password = tokens[3];
        return true;
    }

    @Override
    public void executeCommand(String command) {

    }
}
