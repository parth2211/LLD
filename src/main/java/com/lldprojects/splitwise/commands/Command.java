package com.lldprojects.splitwise.commands;

public interface Command {
    boolean parseCommand(String command);

    void executeCommand(String command);
}
