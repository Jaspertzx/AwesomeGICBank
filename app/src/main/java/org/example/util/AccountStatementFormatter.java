package org.example.util;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.example.model.Statement;

/**
 * Formats the account statement to the desired format.
 */
public class AccountStatementFormatter {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("d MMM uuuu hh:mm:ssa");

    public static String getPrintReadyStatement(List<Statement> listOfStatements) {
        StringBuilder totalPrint = new StringBuilder("Date                   | Amount     | Balance\n");
        for (Statement statement : listOfStatements) {
            totalPrint.append(String.format("%-21s | %-10.2f | %-10.2f\n",
                    DATE_FORMATTER.format(statement.getDate()),
                    statement.getAmount(),
                    statement.getBalance()));
        }
        return totalPrint.toString();
    }
}
