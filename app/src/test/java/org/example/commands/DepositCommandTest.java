package org.example.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.example.model.BankAccount;
import org.example.model.Model;
import org.example.model.Statement;
import org.junit.jupiter.api.Test;

/**
 * Tests the DepositCommand object.
 */
public class DepositCommandTest {

    @Test
    public void execute_depositExecutedByCommand_depositSuccessful() {
        TestModelAccept testModelAccept = new TestModelAccept();
        double value = 10.00;
        DepositCommand depositCommand = new DepositCommand(value);
        CommandResult commandResult = depositCommand.execute(testModelAccept);
        assertEquals(commandResult.getFeedback(), String.format(DepositCommand.SUCCESS_MESSAGE, value));
    }

    @Test
    public void execute_depositExecutedByCommand_depositFailure() {
        TestModelAccept testModelAccept = new TestModelAccept();
        double value = -10.00;
        DepositCommand depositCommand = new DepositCommand(value);
        CommandResult commandResult = depositCommand.execute(testModelAccept);
        assertEquals(commandResult.getFeedback(), DepositCommand.ERROR_GO_BACK_MESSAGE);
    }

    @Test
    public void execute_depositExecutedByCommand_goBackMainMenu() {
        TestModelAccept testModelAccept = new TestModelAccept();
        double value = 0.00;
        DepositCommand depositCommand = new DepositCommand(value);
        CommandResult commandResult = depositCommand.execute(testModelAccept);
        assertEquals(commandResult.getFeedback(), DepositCommand.GO_BACK_MESSAGE);
    }


    /**
     * A test model that have all the methods failing.
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


    private class TestModelAccept extends DepositCommandTest.TestModel {
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


    }
}
