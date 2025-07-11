package com.preprations.exception;

public class BankAccount {
    private double balance;

    public BankAccount(double initialAmount) {
        this.balance = initialAmount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance! Current: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + " | New Balance: " + balance);
    }
}
