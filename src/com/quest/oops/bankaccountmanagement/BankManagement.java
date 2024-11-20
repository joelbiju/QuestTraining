package com.quest.oops.bankaccountmanagement;

import java.util.Scanner;

public class BankManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = null;

        while (true) {
            System.out.println("\n--- Bank Account Management System ---");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. View Account Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = getValidInt(sc);
            switch (choice) {
                case 1: {
                    System.out.print("Enter Account Number: ");
                    String savingAccountNumber = sc.next();
                    System.out.print("Enter Account Holder Name: ");
                    String savingAccountHolderName = sc.next();
                    System.out.print("Enter Initial Balance: ");
                    double savingInitialBalance = sc.nextDouble();
                    account = new BankAccount(savingAccountNumber, savingAccountHolderName, savingInitialBalance);
                    System.out.println("Savings Account Created");
                    break;
                }
                case 2: {
                    System.out.print("Enter Account Number: ");
                    String currentAccountNumber = sc.next();
                    System.out.print("Enter Account Holder Name: ");
                    String currentAccountHolderName = sc.next();
                    System.out.print("Enter Initial Balance: ");
                    double currentInitialBalance = sc.nextDouble();
                    account = new BankAccount(currentAccountNumber, currentAccountHolderName, currentInitialBalance);
                    System.out.println("Current Account Created");
                    break;
                }
                case 3: {
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        Transaction deposit = new Deposit(account);
                        deposit.processTransaction(depositAmount);
                    } else {
                        System.out.print("Sorry, no account found");
                    }
                    break;
                }
                case 4: {
                    if (account != null) {
                        System.out.print("Enter withdraw amount: ");
                        double withdrawAmount = sc.nextDouble();
                        Transaction withdraw = new Withdraw(account);
                        withdraw.processTransaction(withdrawAmount);
                    } else {
                        System.out.print("Sorry, no account found");
                    }
                    break;
                }
                case 5: {
                    if (account != null) {
                        account.displayDetails();
                    } else {
                        System.out.print("Sorry, no account found");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Exiting... Thank you for using Bank Management System!");
                    break;
                }
                default: {
                    System.out.print("Invalid choice. Please try again. ");
                }
            }
        }
    }

    public static int getValidInt(Scanner sc) {
        while (true) {
            if (sc.hasNextInt()) {
                int number = sc.nextInt();
                if (number > 0) {
                    return number;
                } else {
                    System.out.println("Invalid input, please enter a positive number");
                }
            } else {
                System.out.println("Please enter a valid number");
                sc.nextLine();
            }
        }
    }
}
