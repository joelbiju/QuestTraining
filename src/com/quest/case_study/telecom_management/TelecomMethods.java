package com.quest.case_study.telecom_management;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TelecomMethods implements TelecomInterface {
    private List<Subscriber> subscribers = new ArrayList<>();
    private static final String DATA_FILE = "telecom_data.ser";

    public TelecomMethods() {
        loadData();
    }

    @Override
    public void addSubscriber(Scanner scanner) {
        try {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();

            if (findSubscriberById(id) != null) {
                throw new Exception("Subscriber with this ID already exists");
            }
            scanner.nextLine();

            System.out.print("Enter Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter Phone Number: ");
            String phone = scanner.nextLine();

            System.out.print("Enter Plan Type (Prepaid/Postpaid): ");
            String plan = scanner.nextLine();

            if (!plan.equalsIgnoreCase("prepaid") && !plan.equalsIgnoreCase("postpaid")) {
                throw new Exception("Error: Plan Type must be either 'Prepaid' or 'Postpaid'.");
            }

            System.out.print("Enter Balance: ");
            double balance = scanner.nextDouble();

            subscribers.add(new Subscriber(id, name, phone, plan, balance));
            System.out.println("Subscriber added successfully.");
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateSubscriberBalance(Scanner scanner) {
        try {
            System.out.print("Enter Subscriber ID: ");
            int id = scanner.nextInt();
            Subscriber subscriber = findSubscriberById(id);

            if (subscriber != null) {
                System.out.print("Enter New Balance: ");
                double balance = scanner.nextDouble();
                subscriber.setBalance(balance);
                System.out.println("Balance updated successfully.");
            } else {
                System.out.println("Subscriber not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine();
        }
    }

    @Override
    public void listSubscribers() {
        if (subscribers.isEmpty()) {
            System.out.println("No subscribers found.");
        } else {
            for (Subscriber s : subscribers) {
                System.out.println(s);
            }
        }
    }

    @Override
    public void addCallRecord(Scanner scanner) {
        try {
            System.out.print("Enter Subscriber ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Check if subscriber exists
            Subscriber subscriber = findSubscriberById(id);
            if (subscriber == null) {
                System.out.println("Subscriber not found.");
                return;
            }

            System.out.print("Enter Call Type (Local/STD/ISD): ");
            String callTypeInput = scanner.nextLine().toUpperCase();

            CallType callType = null;
            try {
                callType = CallType.valueOf(callTypeInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: Call Type must be either 'LOCAL', 'STD', or 'ISD'.");
                return;
            }

            System.out.print("Enter Duration (in minutes): ");
            double duration = scanner.nextDouble();

            // Add the call record
            CallRecord callRecord = new CallRecord(callType, duration);
            subscriber.getCallRecords().add(callRecord);
            System.out.println("Call record added successfully.");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine(); // Clear the buffer
        }
    }

    @Override
    public void displayCallHistory(Scanner scanner) {
        try {
            System.out.print("Enter Subscriber ID: ");
            int id = scanner.nextInt();

            Subscriber subscriber = findSubscriberById(id);
            if (subscriber != null) {
                List<CallRecord> records = subscriber.getCallRecords();
                if (records.isEmpty()) {
                    System.out.println("No call history found for this subscriber.");
                } else {
                    for (CallRecord record : records) {
                        System.out.println(record);
                    }
                }
            } else {
                System.out.println("Subscriber not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please try again.");
            scanner.nextLine();
        }
    }

    @Override
    public void generateBill(Scanner scanner) {
        try {
            System.out.print("Enter Subscriber ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            // Find subscriber by ID
            Subscriber subscriber = findSubscriberById(id);

            if (subscriber != null && "Postpaid".equalsIgnoreCase(subscriber.getPlanType())) {
                List<CallRecord> records = subscriber.getCallRecords();

                // Check if the subscriber has any call records
                if (records.isEmpty()) {
                    System.out.println("No calls found for billing.");
                } else {
                    double totalBill = 0;

                    // Iterate to calculate the total bill
                    for (CallRecord record : records) {
                        switch (record.getType()) {
                            case LOCAL:
                                totalBill += record.getDuration(); // ₹1 per minute for local calls
                                break;
                            case STD:
                                totalBill += record.getDuration() * 2; // ₹2 per minute for STD calls
                                break;
                            case ISD:
                                totalBill += record.getDuration() * 5; // ₹5 per minute for ISD calls
                                break;
                        }
                    }

                    // Output the total bill
                    System.out.println("Total Bill for Subscriber ID " + id + ": ₹" + totalBill);
                }
            } else {
                System.out.println("Subscriber not found or not a postpaid customer.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid Subscriber ID.");
            scanner.nextLine(); // Clear buffer
        }
    }


    @Override
    public void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(subscribers);
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @Override
    public void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            subscribers = (List<Subscriber>) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }

    private Subscriber findSubscriberById(int id) {
        for (Subscriber s : subscribers) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
