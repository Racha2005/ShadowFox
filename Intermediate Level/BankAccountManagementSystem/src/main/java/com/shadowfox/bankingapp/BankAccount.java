package com.shadowfox.bankingapp;

public class BankAccount {
    private String accountHolder;
    private int balance;

    public BankAccount(String accountHolder, int initialBalance) {
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance!");
        }
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public String transactionSummary() {
        return "Account Holder: " + accountHolder + "\nBalance: " + balance;
    }
}