package com.challenge.enums;

public enum CommandType {

    CREATE_CANVAS("C"),
    DRAW_LINE("L"),
    DRAW_RECTANGLE("R"),
    FILL_EMPTY_AREA("B"),
    EXIT("Q");

    private final String command;

    CommandType(String command) {
        this.command = command;
    }

    public String getValue() {
        return this.command;
    }
}
