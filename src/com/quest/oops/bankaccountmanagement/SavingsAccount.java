package com.quest.oops.bankaccountmanagement;

public class SavingsAccount extends BankAccount {
    private static final double MIN_BALANCE = 500;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public boolean withdraw(double amount) {
        if ((getBalance() - amount) >= MIN_BALANCE) {
            return super.withdraw(amount);
        } else {
            System.out.println("Insufficient balance");
            return false;
        }
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Account Type: SAVINGS");
        System.out.println("Minimum Balance: $" + MIN_BALANCE);
    }
}
