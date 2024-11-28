package com.quest.case_study.telecom_management;

import java.util.Scanner;

public class MainManagement {
    public static void main(String[] args) {
        TelecomMethods telecom = new TelecomMethods();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("\nTelecom Management System");
            System.out.println("1. Add Subscriber");
            System.out.println("2. Update Subscriber Balance");
            System.out.println("3. List All Subscribers");
            System.out.println("4. Add Call Record");
            System.out.println("5. Display Call History");
            System.out.println("6. Generate Bill");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1: {
                    telecom.addSubscriber(scanner);
                    break;
                }
                case 2: {
                    telecom.updateSubscriberBalance(scanner);
                    break;
                }
                case 3: {
                    telecom.listSubscribers();
                    break;
                }
                case 4: {
                    telecom.addCallRecord(scanner);
                    break;
                }
                case 5: {
                    telecom.displayCallHistory(scanner);
                    break;
                }
                case 6: {
                    telecom.generateBill(scanner);
                    break;
                }
                case 7: {
                    telecom.saveData();
                    System.out.println("Data Saved. Exiting...");
                    return;
                }
                default: {
                    System.out.println("Invalid choice. Try again.");
                }
            }
        }
    }
}
