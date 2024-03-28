package org.example.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
* Acts as an immutable object to hold Statement details.
*
*/
public class Statement implements Serializable {
    private static final long serialVersionUID = 1L;

    private final LocalDateTime date;

    private final double amount;

    private final double balance;

    /**
    * Creates and sets final variables for Statement Object.
    *
    * @param amount the amount withdrew/deposited.
    * @param balance leftover bank balance.
    */
    public Statement(double amount, double balance) {
        this.date = this.getCurrentDataAndTime();
        this.amount = amount;
        this.balance = balance;
    }

    public LocalDateTime getCurrentDataAndTime() {
        return LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public double getAmount() {
        return this.amount;
    }

    public double getBalance() {
        return this.balance;
    }
}
