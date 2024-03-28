package org.example.model;

import java.util.List;

/**
 * Acts as the API of the Model component;
 * allows for a transaction layer without exposing the inner workings of the application.
 */
public interface Model {

    /**
     * Gets the user input from CLI terminal.
     *
     * @param promptMessage the prompt to be printed.
     * @return the user input.
     */
    String getUserInput(String promptMessage);
    /**
     * Performs a deposit onto the bank account and creates the necessary statement.
     *
     * @param amount the amount to be added.
     */
    void performDeposit(double amount);

    /**
     * Performs a withdrawal onto the bank account and creates the necessary statement.
     *
     * @param amount the amount to be deducted.
     */
    boolean performWithdrawal(double amount);

    /**
     * Get the current list of statements.
     *
     * @return an immutable array of statements for viewing.
     */
    List<Statement> getStatementList();
    /**
     * Get the current bank balance.
     *
     * @return current bank balance.
     */
    Double getBankBalance();
}
