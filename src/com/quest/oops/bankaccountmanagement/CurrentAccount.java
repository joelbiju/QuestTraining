package com.quest.oops.bankaccountmanagement;

public class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 1000;

    public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public boolean withdraw(double amount) {
        if ((getBalance() + OVERDRAFT_LIMIT) >= amount) {
            return super.withdraw(amount);
        } else {
            System.out.println("Overdraft limit exceeded");
            return false;
        }
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: CURRENT");
        System.out.println("Overdraft Limit: " + OVERDRAFT_LIMIT);
    }
}
