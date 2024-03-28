package org.example.storage;

import org.example.model.BankAccount;
import org.example.model.StatementList;

/**
 * Acts as the API of the Storage component; allows for a transaction layer without exposing the inner workings of the
 * application.
 */
public interface Storage {

    /**
     * Stores the current user created Statements.
     */
    boolean storeCurrentStatements(StatementList statementList);
    /**
     * Stores the current user bank account.
     */
    boolean storeCurrentBankAccount(BankAccount bankAccount);

    /**
     * Loads the saved statements from storage.
     * @return the saved StatementList.
     */
    StatementList loadStatements();

    /**
     * Loads the saved balance from storage.
     * @return the BankAccount object with the updated amount.
     */
    BankAccount loadBankAccount();

    /**
     * Checks if both StatementList and BankAccount storages are available.
     * @return True if both are, false if either or both are not.
     */
    boolean storageCheck();
}
