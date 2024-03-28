package org.example.logic;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.example.commands.Command;
import org.example.commands.DepositCommand;
import org.example.commands.PrintStatementCommand;
import org.example.commands.QuitCommand;
import org.example.commands.WithdrawCommand;
import org.example.exceptions.ParseException;
import org.example.util.Messages;

/**
 * Parses the user input.
 */
public class CommandParser {
    private static final Pattern COMMAND_FORMAT = Pattern.compile("(?<commandType>\\S+)");

    /**
     * Parses the user input to create the respective Command objects.
     *
     * @param userInput the user's String input.
     * @return the respective Command object created.
     * @throws ParseException if the input does not follow the conventions.
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher stringMatcher = COMMAND_FORMAT.matcher(userInput.trim());

        if (!stringMatcher.matches()) {
            throw new ParseException(Messages.getInvalidCommandMessage());
        }

        final String commandType = stringMatcher.group("commandType").toUpperCase();

        switch (commandType) {
        case DepositCommand.COMMAND_TYPE:
            return new DepositCommandParser().parseArguments();
        case WithdrawCommand.COMMAND_TYPE:
            return new WithdrawCommandParser().parseArguments();
        case PrintStatementCommand.COMMAND_TYPE:
            return new PrintStatementCommand();
        case QuitCommand.COMMAND_TYPE:
            return new QuitCommand();
        default:
            throw new ParseException(Messages.getInvalidCommandMessage());
        }
    }
}
