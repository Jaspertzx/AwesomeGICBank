package org.example.model;

import java.io.Serializable;

/**
 * Represents the BankAccount object and keeps track of the bank balance.
 */
public class BankAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    private double balance;

    /**
     * Initializes the bank account.
     */
    public BankAccount() {
        this.balance = 0.0;
    }

    /**
     * Initializes a copy of a bank account.
     * This is to ensure immutability when passing around the BankAccount object.
     */
    public BankAccount(BankAccount other) {
        this.balance = other.balance;
    }

    /**
     * Deposits the amount into the bank by adding it with the total amount.
     * @param amount to be added.
     */
    public void deposit(double amount) {
        if (this.balance + amount > Double.MAX_VALUE) {
            System.out.println("Max capacity hit! Double overflow!");
        }
        this.balance += amount;
    }

    /**
     * Removes the amount specified from the total bank account total.
     * If the amount specified is more than the bank account total, will return false to indicate that the
     * transaction was not successful; otherwise returns True.
     * @param amount the specified amount to deduct.
     * @return if the operation was a success, true if it is, and false otherwise.
     */
    public boolean withdraw(double amount) {
        if (this.balance < amount) {
            return false;
        }
        this.balance -= amount;
        return true;
    }

    public double getBalance() {
        return this.balance;
    }

}

