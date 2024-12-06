package com.quest.workout.afternoon_workout;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IndianDate {
    public static void main(String[] args) {
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String formattedDate = formatter.format(currentDate);
        System.out.println("Simple date: " + formattedDate);
    }
}
