package org.example.commands;

/**
 * Represents the result after a Command is executed.
 * Holds both success and unsuccessful attempts to execute the model.
 */
public class CommandResult {
    private final String feedback;

    private final boolean isExit;

    /**
     * Creates a CommandResult object with a feedback, and not an exit command.
     * @param feedback to show the user.
     */
    public CommandResult(String feedback) {
        this.feedback = feedback;
        this.isExit = false;
    }

    /**
     * Creates a CommandResult object with a feedback, and an exit command.
     * @param feedback to show the user.
     * @param isExit to exit the application or not.
     */
    public CommandResult(String feedback, boolean isExit) {
        this.feedback = feedback;
        this.isExit = isExit;
    }

    public boolean isExit() {
        return this.isExit;
    }

    public String getFeedback() {
        return this.feedback;
    }
}
