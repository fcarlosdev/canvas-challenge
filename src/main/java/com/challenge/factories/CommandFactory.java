package com.challenge.factories;

import com.challenge.commands.Command;

import java.util.HashMap;
import java.util.Map;

public final class CommandFactory {

    private Map<String, Command> commands;

    public CommandFactory() {
        this.commands = new HashMap<>();
    }

    public void addCommand(final String operation, final Command command) {
        this.commands.put(operation,command);
    }

    public void executeCommand(String operation) {
        if (commands.containsKey(operation)) {
            commands.get(operation).execute();
        }
    }

    public static CommandFactory init() {

        return new CommandFactory();
    }


}
