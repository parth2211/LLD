package com.lldprojects.splitwise.commands.registry;

import com.lldprojects.splitwise.commands.Command;

public interface CommandRegistry {
    void addCommand(Command command);

    void removeCommand(Command command);

    boolean checkCommand(String command);

    void execCommand(String string);
}
