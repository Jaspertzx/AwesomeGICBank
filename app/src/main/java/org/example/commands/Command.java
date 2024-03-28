package org.example.commands;

import org.example.model.Model;

/**
 * Represents a command layer, hiding the internal logic of the application and gives the ability for the command to be
 * executed.
 */
public interface Command {
    abstract CommandResult execute(Model model);
}
