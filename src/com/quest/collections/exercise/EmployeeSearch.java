package com.quest.collections.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> employeeMap = new HashMap<>();

        employeeMap.put(101, "Alice");
        employeeMap.put(102, "Bob");
        employeeMap.put(103, "Charlie");
        employeeMap.put(104, "David");
        employeeMap.put(105, "Eva");

        System.out.println("Employee Data: " + employeeMap);

        System.out.print("Enter Employee ID to search: ");
        int employeeId = sc.nextInt();

        if (employeeMap.containsKey(employeeId)) {
            System.out.println("Employee found: ");
            System.out.println("Employee ID: " + employeeId+ " Employee Name: " + employeeMap.get(employeeId));
        } else {
            System.out.println("Employee not found");
        }
    }
}
