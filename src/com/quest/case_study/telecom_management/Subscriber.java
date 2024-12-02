package com.quest.case_study.telecom_management;

import java.io.Serializable;
import java.util.ArrayList;

public class Subscriber implements Serializable {
    private int id;
    private String name;
    private String phoneNumber;
    private String planType;
    private double balance;
    private ArrayList<CallRecord> callRecords;

    public Subscriber(int id, String name, String phoneNumber, String planType, double balance) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.planType = planType;
        this.balance = balance;
        this.callRecords = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPlanType() {
        return planType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<CallRecord> getCallRecords() {
        return callRecords;
    }

    public void addCallRecord(CallRecord record) {
        callRecords.add(record);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Phone: " + phoneNumber + ", Plan: " + planType + ", Balance: ₹" + balance;
    }
}
