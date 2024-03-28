package org.example.storage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.example.model.StatementList;
/**
 * Handles the storing of statements of the user.
 */
public class StatementStorage {

    private final String storagePath;

    /**
     * Creates the StatementStorage object to handle storing of statements.
     * @param filePath to store the StatementList object.
     */
    public StatementStorage(String filePath) {
        this.storagePath = filePath;
    }


    /**
     * Saves the given StatementList to a file.
     *
     * @param statementList The list of Statement objects to save.
     */
    public boolean saveStatements(StatementList statementList) {
        Path storageDir = Paths.get(StorageManager.STORAGE_DIRECTORY);
        try {
            Files.createDirectories(storageDir);
        } catch (IOException e) {
            return false;
        }
        try (FileOutputStream fileOut = new FileOutputStream(this.storagePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(statementList);
        } catch (IOException e) {
            return false;
        } catch (ClassCastException e) {
            return false;
        }
        return true;
    }

    /**
     * Loads the StatementList from the file.
     * If an error is caught, will start the save anew.
     * @return The loaded StatementList, or an empty one if none exists.
     */
    public StatementList loadStatements() {
        if (!Files.exists(Paths.get(storagePath))) {
            return new StatementList();
        }

        try (FileInputStream fileIn = new FileInputStream(storagePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            return (StatementList) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new StatementList();
        }
    }

    /**
     * Checks if storage is accessible.
     *
     * @return True if it is, False if it is not.
     */
    public boolean checkStatementStorage() {
        if (!Files.exists(Paths.get(storagePath))) {
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
