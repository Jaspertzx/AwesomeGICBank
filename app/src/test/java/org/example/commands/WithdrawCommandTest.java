package org.example.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.example.model.BankAccount;
import org.example.model.Model;
import org.example.model.Statement;
import org.junit.jupiter.api.Test;

/**
 * Tests the WithdrawCommand object.
 */
public class WithdrawCommandTest {

    @Test
    public void execute_withdrawExecutedByCommand_withdrawSuccessful() {
        TestModelAccept testModelAccept = new TestModelAccept();
        double value = 10.00;
        DepositCommand depositCommand = new DepositCommand(value);
        CommandResult commandResult = depositCommand.execute(testModelAccept);
        WithdrawCommand withdrawCommand = new WithdrawCommand(value);
        commandResult = withdrawCommand.execute(testModelAccept);
        assertEquals(commandResult.getFeedback(), String.format(WithdrawCommand.SUCCESS_MESSAGE, value));
    }

    @Test
    public void execute_withdrawExecutedByCommand_withdrawFailure() {
        TestModelAccept testModelAccept = new TestModelAccept();
        double value = 10.00;
        DepositCommand depositCommand = new DepositCommand(value);
        CommandResult commandResult = depositCommand.execute(testModelAccept);
        value = 20.00;
        WithdrawCommand withdrawCommand = new WithdrawCommand(value);
        commandResult = withdrawCommand.execute(testModelAccept);
        assertEquals(commandResult.getFeedback(), String.format(WithdrawCommand.FAILURE_MESSAGE,
                testModelAccept.getBankBalance()));
    }

    @Test
    public void execute_zeroValueWithdrawExecutedByCommand_goBackMainMenu() {
        TestModelAccept testModelAccept = new TestModelAccept();
        double value = 10.00;
        DepositCommand depositCommand = new DepositCommand(value);
        CommandResult commandResult = depositCommand.execute(testModelAccept);
        value = 0.00;
        WithdrawCommand withdrawCommand = new WithdrawCommand(value);
        commandResult = withdrawCommand.execute(testModelAccept);
        assertEquals(commandResult.getFeedback(), WithdrawCommand.GO_BACK_MESSAGE);
    }


    /**
     * A test model that have all of the methods failing.
     */
    private class TestModel implements Model {
        @Override
        public String getUserInput(String promptMessage) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void performDeposit(double amount) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean performWithdrawal(double amount) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public List<Statement> getStatementList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Double getBankBalance() {
            throw new AssertionError("This method should not be called.");
        }
    }


    private class TestModelAccept extends WithdrawCommandTest.TestModel {
        private final BankAccount bankAccount;

        /**
         * Initializes the required variables and objects for the application.
         */
        public TestModelAccept() {
            this.bankAccount = new BankAccount();
        }

        @Override
        public void performDeposit(double amount) {
            this.bankAccount.deposit(amount);
        }

        @Override
        public boolean performWithdrawal(double amount) {
            return this.bankAccount.withdraw(amount);
        }

        @Override
        public Double getBankBalance() {
            return this.bankAccount.getBalance();
        }


    }
}
