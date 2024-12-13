package com.quest.case_study.bank_transaction_management;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("SBI00101201", 25000.00);

        Runnable depositTask1 = () -> bankAccount.deposit(5000.00);
        Runnable withdrawalTask1 = () -> bankAccount.withdraw(5000.00);
        Runnable withdrawalTask2 = () -> bankAccount.withdraw(10000.00);
        Runnable depositTask2 = () -> bankAccount.deposit(500.00);
        Runnable depositTask3 = () -> bankAccount.deposit(1000.00);

        Thread depositThread1 = new Thread(depositTask1);
        Thread depositThread2 = new Thread(depositTask2);
        Thread depositThread3 = new Thread(depositTask3);
        Thread withdrawalThread1 = new Thread(withdrawalTask1);
        Thread withdrawalThread2 = new Thread(withdrawalTask2);

        depositThread1.start();
        withdrawalThread1.start();
        depositThread2.start();
        withdrawalThread2.start();
        depositThread3.start();

        try {
            depositThread1.join();
            withdrawalThread1.join();
            depositThread2.join();
            withdrawalThread2.join();
            depositThread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nInitial balance: 25000.00");
        bankAccount.getTransactionLog().stream().forEach(System.out::println);
        System.out.println("\nCurrent balance: "+bankAccount.getBalance());



    }
}
