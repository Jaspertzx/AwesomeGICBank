package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
* Encapsulates the list for the statement, to handle the storage of Statements.
* Prevents unintentional deleting of previous statements, and only allows new
* statements to be added.
*/
public class StatementList implements Serializable {
    private static final long serialVersionUID = 1L;

    private final List<Statement> statements;

    /**
    * Creates an empty list for the storage of statements.
    * Developer Note: To add persistent storage, implement storage reading methods
    * here.
    */
    public StatementList() {
        this.statements = new ArrayList<>();
    }

    /**
    * Adds a statement to the current Statement list.
    * @param statement the statement to add.
    */
    public void addStatement(Statement statement) {
        this.statements.add(statement);
    }

    /**
     * Creates and returns an unmodifiable list of Statements.
     * @return unmodifiable List of Statements.
     */
    public List<Statement> getStatements() {
        return Collections.unmodifiableList(this.statements);
    }

}
