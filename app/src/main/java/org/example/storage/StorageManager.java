package org.example.storage;

import org.example.model.BankAccount;
import org.example.model.StatementList;

/**
 * Implements the logic required by the Storage layer.
 */
public class StorageManager implements Storage {
    public static final String STORAGE_DIRECTORY = "AwesomeGICBankData";
    private final String storagePathStatements = STORAGE_DIRECTORY + "/statements.txt";
    private final String storagePathBankAccount = STORAGE_DIRECTORY + "/bankaccount.txt";
    private final StatementStorage statementStorage;
    private final BankAccountStorage bankAccountStorage;

    /**
     * Creates the StorageManager objects and initializes the individual model storage objects with the filepath.
     */
    public StorageManager() {
        this.statementStorage = new StatementStorage(storagePathStatements);
        this.bankAccountStorage = new BankAccountStorage(storagePathBankAccount);
    }

    /**
     * Stores the current user created Statements.
     */
    @Override
    public boolean storeCurrentStatements(StatementList statementList) {
        return this.statementStorage.saveStatements(statementList);
    }

    /**
     * Stores the current user bank account.
     */
    @Override
    public boolean storeCurrentBankAccount(BankAccount bankAccount) {
        return this.bankAccountStorage.saveBankAccount(bankAccount);
    }

    /**
     * Loads the saved statements from storage.
     *
     * @return the saved StatementList.
     */
    @Override
    public StatementList loadStatements() {
        return this.statementStorage.loadStatements();
    }

    /**
     * Loads the saved balance from storage.
     *
     * @return the BankAccount object with the updated amount.
     */
    @Override
    public BankAccount loadBankAccount() {
        return this.bankAccountStorage.loadBankAccount();
    }

    /**
     * Checks if both StatementList and BankAccount storages are available.
     * @return True if both are, false if either or both are not.
     */
    @Override
    public boolean storageCheck() {
        boolean isStatementStorageAvail = this.statementStorage.checkStatementStorage();
        boolean isBankAccountStorageAvail = this.bankAccountStorage.checkBankAccountStorage();
        return isBankAccountStorageAvail && isStatementStorageAvail;
    }
}
