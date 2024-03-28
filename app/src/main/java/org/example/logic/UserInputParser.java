package org.example.logic;

import java.util.Scanner;

/**
 * Acts as a scanner object to show the prompt message for user and takes their input accordingly.
 * Is a Singleton class.
 */
public class UserInputParser {
    private static UserInputParser instance;

    private String promptMessage;

    private final Scanner scanner;

    /**
     * Creates the UserInputParser for this class and initializes the scanner.
     */
    private UserInputParser() {
        this.scanner = new Scanner(System.in);
    }

    public static synchronized UserInputParser getInstance() {
        if (instance == null) {
            instance = new UserInputParser();
        }
        return instance;
    }

    public void setPromptMessage(String promptMessage) {
        this.promptMessage = promptMessage;
    }

    public String getUserPrompt() {
        System.out.println(this.promptMessage);
        return instance.scanner.nextLine();
    }

    public void closeUserInputParser() {
        this.scanner.close();
    }

    /**
     * Validates the String input to be a proper cash value.
     * This means that the cash input has to be a numerical value with at most 2 decimal places, and is none negative.
     * @param userInput the input to be validated.
     * @return if the input is a proper cash value.
     */
    public static boolean validCashValue(String userInput) {
        Double amount;
        try {
            amount = Double.parseDouble(userInput);
            if (amount < 0) {
                return false; // Check for non-negative values.
            }

            // Check for more than two decimal places.
            String[] parts = userInput.split("\\.");
            if (parts.length > 1 && parts[1].length() > 2) {
                return false; // More than two decimal places.
            }
        } catch (NumberFormatException e) {
            return false; // Input was not a valid double.
        }
        return true;
    }
}
