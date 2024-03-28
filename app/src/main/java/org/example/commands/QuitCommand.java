package org.example.commands;

import org.example.model.Model;

/**
 * Represents the user quitting the application.
 */
public class QuitCommand implements Command {
    public static final String SUCCESS_MESSAGE = "Thank you for banking with AwesomeGIC Bank.\nHave a nice day!";
    public static final String COMMAND_TYPE = "Q";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(SUCCESS_MESSAGE, true);
    }
}
