package org.example.util;

/**
 * Contains messages for printing and interacting with the user.
 */
public class Messages {
    public static final String GREETING_MESSAGE = "Welcome to AwesomeGIC Bank! What would you like to do?\n";

    public static final String CONTINUE_MESSAGE = "Is there anything else you'd like to do?\n";

    public static final String INSTRUCTIONS_MESSAGE = "[D]eposit\n[W]ithdraw\n[P]rint\n[Q]uit";

    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Unrecognized command, "
            + "please refer to instruction list.";

    public static String getStartUpMessage() {
        return GREETING_MESSAGE + INSTRUCTIONS_MESSAGE;
    }

    public static String getContinueMessage() {
        return CONTINUE_MESSAGE + INSTRUCTIONS_MESSAGE;
    }

    public static String getInvalidCommandMessage() {
        return MESSAGE_INVALID_COMMAND_FORMAT + "\n" + INSTRUCTIONS_MESSAGE;
    }
}
