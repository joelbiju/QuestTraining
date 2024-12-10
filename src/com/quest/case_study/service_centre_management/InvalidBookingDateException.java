package com.quest.case_study.service_centre_management;

public class InvalidBookingDateException extends Exception {
    public InvalidBookingDateException(String message) {
        super(message);
    }
}
