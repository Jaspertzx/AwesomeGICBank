package org.example.commands;

import org.example.logic.UserInputParser;
import org.example.model.Model;

/**
 * Represents a depositing action, where the User deposits money into BankAccount object.
 */
public class DepositCommand implements Command {
    public static final String MESSAGE_GET_ARGUMENTS = "Please enter the amount to deposit:";

    public static final String INVALID_MESSAGE_GET_ARGUMENTS = "That is not a valid amount. "
            + "Amount must a positive number with 2 decimal places. \n Please enter the amount to deposit again:";

    public static final String SUCCESS_MESSAGE = "Thank you. $%1$.2f has been deposited to your account.";

    public static final String GO_BACK_MESSAGE = "Going back to main options.";

    public static final String ERROR_GO_BACK_MESSAGE = "An invalid amount has been provided, going back to main"
            + " options.";

    public static final String COMMAND_TYPE = "D";

    private final double amount;

    public DepositCommand(double amount) {
        this.amount = amount;
    }

    @Override
    public CommandResult execute(Model model) {
        if (this.amount == 0) {
            return new CommandResult(GO_BACK_MESSAGE);
        }
        boolean isValid = UserInputParser.validCashValue(String.valueOf(this.amount));
        if (isValid) {
            model.performDeposit(this.amount);
            return new CommandResult(String.format(SUCCESS_MESSAGE, amount));
        }
        return new CommandResult(ERROR_GO_BACK_MESSAGE);
    }
}
