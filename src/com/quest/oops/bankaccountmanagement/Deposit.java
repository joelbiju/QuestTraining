package com.quest.oops.bankaccountmanagement;

public class Deposit extends Transaction {

    public Deposit(BankAccount account) {
        super(account);
    }

    @Override
    public void processTransaction(double amount) {
        if (amount > 0) {
            account.deposit(amount);
            System.out.println("Deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
}
