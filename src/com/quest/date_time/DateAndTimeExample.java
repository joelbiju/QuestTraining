package com.quest.date_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTimeExample {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Local Data: "+currentDateTime);

        //data formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        //applying formatter
        String formattedDate = currentDateTime.format(formatter);

        //output
        System.out.println("Formatted data: "+formattedDate);

        LocalDateTime someOtherDate = LocalDateTime.of(2023,12,12,13,12,45,12321);
        System.out.println("Some other Date: "+someOtherDate);
    }
}
