package com.splitwise.commands;


import com.splitwise.exceptions.InvalidCommandException;

public abstract class Command {

    public void validateAndExecute(String input) throws InvalidCommandException {
        validate(input);
        execute(input);
    }

    public abstract void validate(String input) throws InvalidCommandException;

    public abstract void execute(String input);
}
