package org.example.logic;

import org.example.commands.Command;
import org.example.commands.WithdrawCommand;

/**
 * Parses user input for WithdrawCommand.
 */
public class WithdrawCommandParser implements Parser {
    private UserInputParser userInputParser;

    /**
     * Initializes the parser and parses arguments required.
     */
    public WithdrawCommandParser() {
        this.userInputParser = UserInputParser.getInstance();
    }

    @Override
    public Command parseArguments() {
        this.userInputParser.setPromptMessage(WithdrawCommand.MESSAGE_GET_ARGUMENTS);

        String userInput = this.userInputParser.getUserPrompt();
        boolean isValid = UserInputParser.validCashValue(userInput);
        while (!isValid) {
            this.userInputParser.setPromptMessage(WithdrawCommand.INVALID_MESSAGE_GET_ARGUMENTS);
            userInput = this.userInputParser.getUserPrompt();
            isValid = UserInputParser.validCashValue(userInput);
        }
        return new WithdrawCommand(Double.parseDouble(userInput));
    }
}
