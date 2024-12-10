package com.quest.case_study.service_centre_management;

import java.time.LocalDateTime;

public class ServiceBooking implements Cloneable {

    private String bookingId;
    private Customer customer;
    private LocalDateTime serviceDate;
    private String serviceType;
    private double cost;

    public ServiceBooking(String bookingId, Customer customer, LocalDateTime serviceDate, String serviceType, double cost) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.serviceDate = serviceDate;
        this.serviceType = serviceType;
        this.cost = cost;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDateTime getServiceDate() {
        return serviceDate;
    }

    public String getServiceType() {
        return serviceType;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "ServiceBooking [bookingId:" + bookingId + ",customer:" + customer+ ",serviceDate:" + serviceDate + ",serviceType:" + serviceType + ",cost:" + cost + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            ServiceBooking clonedBooking = (ServiceBooking) super.clone();
            clonedBooking.cost *= 0.9; // Applying 10% discount to the cost
            return clonedBooking;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
