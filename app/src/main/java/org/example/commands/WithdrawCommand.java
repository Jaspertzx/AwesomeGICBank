package org.example.commands;

import org.example.model.Model;

/**
 * Represents a withdrawal action, where the User withdraws money from BankAccount object.
 */
public class WithdrawCommand implements Command {
    public static final String MESSAGE_GET_ARGUMENTS = "Please enter the amount to withdraw:";

    public static final String INVALID_MESSAGE_GET_ARGUMENTS = "That is not a valid amount. "
            + "Amount must a positive number with 2 decimal places. \n Please enter the amount to withdraw again:";

    public static final String SUCCESS_MESSAGE = "Thank you. $%1$.2f has been withdrawn.";

    public static final String GO_BACK_MESSAGE = "Going back to main options.";

    public static final String FAILURE_MESSAGE = "Unfortunately, you do not have sufficient balance to withdraw as you "
            + "only have $%1$.2f left.\nPlease deposit more money to withdraw.";

    public static final String COMMAND_TYPE = "W";

    private final double amount;

    public WithdrawCommand(double amount) {
        this.amount = amount;
    }

    @Override
    public CommandResult execute(Model model) {
        if (this.amount == 0) {
            return new CommandResult(GO_BACK_MESSAGE);
        }
        boolean isSuccess = model.performWithdrawal(this.amount);
        if (isSuccess) {
            return new CommandResult(String.format(SUCCESS_MESSAGE, amount));
        }
        return new CommandResult(String.format(FAILURE_MESSAGE, model.getBankBalance()));
    }
}
