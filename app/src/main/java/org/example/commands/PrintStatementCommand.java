package org.example.commands;

import java.util.List;

import org.example.model.Model;
import org.example.model.Statement;
import org.example.util.AccountStatementFormatter;


/**
 * Creates the statements for the user to view.
 */
public class PrintStatementCommand implements Command {
    public static final String COMMAND_TYPE = "P";

    @Override
    public CommandResult execute(Model model) {
        List<Statement> listOfStatement = model.getStatementList();
        String printReadyStatement = AccountStatementFormatter.getPrintReadyStatement(listOfStatement);
        return new CommandResult(printReadyStatement);
    }
}
