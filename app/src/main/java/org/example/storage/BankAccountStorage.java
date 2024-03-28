package org.example.storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.example.model.BankAccount;

/**
 * Handles storage operations for BankAccount object of the user.
 */
public class BankAccountStorage {
    private final String storagePath;

    /**
     * Creates the BankAccountStorage object to handle storing of BankAccount object.
     * @param filePath to store the BankAccount object.
     */
    public BankAccountStorage(String filePath) {
        this.storagePath = filePath;
    }

    /**
     * Saves the given BankAccount to a file.
     *
     * @param bankAccount The BankAccount to save.
     */
    public boolean saveBankAccount(BankAccount bankAccount) {
        Path storageDir = Paths.get(StorageManager.STORAGE_DIRECTORY);

        try {
            Files.createDirectories(storageDir);
        } catch (IOException e) {
            return false;
        }

        try (FileOutputStream fileOut = new FileOutputStream(storagePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(bankAccount);
        } catch (IOException | ClassCastException e) {
            return false;
        }
        return true;
    }

    /**
     * Loads the BankAccount from the file.
     * If an error is caught, will start the save anew.
     * @return The loaded BankAccount, or a new one if none exists or an error occurs.
     */
    public BankAccount loadBankAccount() {
        if (!new File(storagePath).exists()) {
            return new BankAccount();
        }

        try (FileInputStream fileIn = new FileInputStream(storagePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (BankAccount) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new BankAccount();
        }
    }

    /**
     * Checks if storage is accessible.
     *
     * @return True if it is, False if it is not.
     */
    public boolean checkBankAccountStorage() {
        if (!new File(storagePath).exists()) {
            return false;
        }

        try (FileInputStream fileIn = new FileInputStream(storagePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
