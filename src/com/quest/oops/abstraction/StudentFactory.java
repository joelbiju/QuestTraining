package com.quest.oops.abstraction;

public class StudentFactory {
    public static Student getStudent(String studentName) {
        if (studentName.equalsIgnoreCase("online")){
            return new OnlineStudent();
        } else if (studentName.equalsIgnoreCase("offline")) {
            return new OfflineStudent();
        } else if (studentName.equalsIgnoreCase("regular")) {
            return new RegularStudent();
        } else {
            return null;
        }
    }
}
