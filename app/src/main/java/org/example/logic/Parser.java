package org.example.logic;

import org.example.commands.Command;

/**
 * Acts as an API for parser objects.
 * Works in conjunction with individual parser for each command.
 */
public interface Parser {
    Command parseArguments();
}
