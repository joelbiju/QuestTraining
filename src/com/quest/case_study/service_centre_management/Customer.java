package com.quest.case_study.service_centre_management;

public class Customer {

    private String customerId;
    private String customerName;
    private String customerEmail;
    Vehicle vehicle;

    public Customer(String customerId, String customerName, String customerEmail, Vehicle vehicle) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicle = vehicle;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return "[customerId:"+customerId+",customerName:"+customerName+",customerEmail:"+customerEmail+",vehicles:"+vehicle+"]";
    }
}
