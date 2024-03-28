package org.example.logic;

import org.example.commands.Command;
import org.example.commands.DepositCommand;

/**
 * Parses user input for DepositCommand.
 */
public class DepositCommandParser implements Parser {
    private UserInputParser userInputParser;

    /**
     * Initializes the parser and parses arguments required.
     */
    public DepositCommandParser() {
        this.userInputParser = UserInputParser.getInstance();
    }

    @Override
    public Command parseArguments() {
        this.userInputParser.setPromptMessage(DepositCommand.MESSAGE_GET_ARGUMENTS);
        String userInput = this.userInputParser.getUserPrompt();
        boolean isValid = UserInputParser.validCashValue(userInput);
        while (!isValid) {
            this.userInputParser.setPromptMessage(DepositCommand.INVALID_MESSAGE_GET_ARGUMENTS);
            userInput = this.userInputParser.getUserPrompt();
            isValid = UserInputParser.validCashValue(userInput);
        }
        return new DepositCommand(Double.parseDouble(userInput));
    }
}
