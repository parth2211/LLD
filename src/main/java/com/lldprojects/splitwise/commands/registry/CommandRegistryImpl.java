package com.lldprojects.splitwise.commands.registry;

import com.lldprojects.splitwise.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class CommandRegistryImpl implements CommandRegistry{

    List<Command> commandList = new ArrayList<>();

    @Override
    public void addCommand(Command command) {
        commandList.add(command);
    }

    @Override
    public void removeCommand(Command command) {
        commandList.remove(command);
    }

    @Override
    public boolean checkCommand(String commandString) {
        for(Command command : commandList) {
            if(command.parseCommand(commandString)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void execCommand(String commandString) {
        for(Command command : commandList) {
            if(command.parseCommand(commandString)) {
                command.executeCommand(commandString);
            }
        }
    }
}
