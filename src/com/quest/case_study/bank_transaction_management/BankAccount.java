package com.quest.case_study.bank_transaction_management;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;
    private double balance;
    private List<String> transactionLog;

    public BankAccount(String accountNumber, double initialBalance){
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionLog = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionLog() {
        return transactionLog;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionLog.add("Deposit: " + amount + ", New Balance: " + balance);
        } else {
            transactionLog.add("Failed Deposit: " + amount);
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            transactionLog.add("Withdrawal: " + amount + ", New Balance: " + balance);
        } else {
            transactionLog.add("Failed Withdrawal: " + amount + ", Balance: " + balance);
        }
    }

    @Override
    public String toString() {
        return "BankAccount [accountNumber=" + accountNumber + ", balance=" + balance + ", transactionLog=" + transactionLog+"]";
    }
}
