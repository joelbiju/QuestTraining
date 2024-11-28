package com.quest.case_study.telecom_management;

import java.util.Scanner;

public interface TelecomInterface {
    void addSubscriber(Scanner scanner);
    void updateSubscriberBalance(Scanner scanner);
    void listSubscribers();
    void addCallRecord(Scanner scanner);
    void displayCallHistory(Scanner scanner);
    void generateBill(Scanner scanner);
    void saveData();
    void loadData();
}
