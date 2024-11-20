package com.quest.oops.bankaccountmanagement;

public class Withdraw extends Transaction {

    public Withdraw(BankAccount account) {
        super(account);
    }

    @Override
    public void processTransaction(double amount) {
        if (amount > 0) {
            if (account.withdraw(amount)) {
                System.out.println("Withdraw successful of amount: $" + amount);
            } else {
                System.out.println("Insufficient balance or overdraft limit exceeded");
            }
        } else {
            System.out.println("invalid amount");
        }
    }
}
