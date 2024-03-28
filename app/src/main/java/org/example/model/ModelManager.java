package org.example.model;

import java.util.List;

import org.example.logic.UserInputParser;

/**
 * Implements the logic required by the Model layer.
 */
public class ModelManager implements Model {
    private final StatementList statementList;

    private final UserInputParser userInputParser;

    private final BankAccount bankAccount;

    /**
     * Initializes the required variables and objects for the application.
     */
    public ModelManager() {
        this.statementList = new StatementList();
        this.userInputParser = UserInputParser.getInstance();
        this.bankAccount = new BankAccount();
    }

    /**
     * Sets the required variables and objects for the application, where the objects have been loaded from storage.
     * @param statementList the loaded StatementList object from storage.
     * @param bankAccount the loaded BankAccount object from storage.
     */
    public ModelManager(StatementList statementList, BankAccount bankAccount) {
        this.statementList = statementList;
        this.userInputParser = UserInputParser.getInstance();
        this.bankAccount = bankAccount;
    }

    /**
     * Creates a shallow copy of the BankAccount for storage.
     * Will prevent any unintentional use of this method to edit the User's BankAccount object.
     * @return a copy of the BankAccount object.
     */
    public BankAccount getBankAccountForStorage() {
        return new BankAccount(this.bankAccount);
    }

    /**
     * Get the current list of statements for storage.
     *
     * @return a copy of the StatementList Object.
     */
    public StatementList getStatementListForStorage() {
        return this.statementList;
    }

    /**
     * Gets the user input from CLI terminal.
     *
     * @return the user input.
     */
    @Override
    public String getUserInput(String promptMessage) {
        userInputParser.setPromptMessage(promptMessage);
        return userInputParser.getUserPrompt();
    }

    /**
     * Adds a statement to the session storage.
     */
    @Override
    public void performDeposit(double amount) {
        this.bankAccount.deposit(amount);
        Statement statement = new Statement(amount, this.bankAccount.getBalance());
        statementList.addStatement(statement);
    }

    /**
     * Performs a withdrawal onto the bank account and creates the necessary statement.
     * Developer Note: isSuccess can be changed to a custom class to accommodate more rejection reasons.
     *
     * @param amount the amount to be deducted.
     */
    @Override
    public boolean performWithdrawal(double amount) {
        boolean isSuccess = this.bankAccount.withdraw(amount);
        if (isSuccess) {
            Statement statement = new Statement(-amount, this.bankAccount.getBalance());
            statementList.addStatement(statement);
        }
        return isSuccess;
    }

    /**
     * Get the current list of statements.
     *
     * @return an immutable array of statements for viewing.
     */
    @Override
    public List<Statement> getStatementList() {
        return this.statementList.getStatements();
    }

    /**
     * Get the current bank balance.
     *
     * @return current bank balance.
     */
    @Override
    public Double getBankBalance() {
        return this.bankAccount.getBalance();
    }
}
