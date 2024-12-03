//Create a Map where keys are employee IDs, and values are their names.
// Implement search functionality to fetch a name by entering the employee ID.

package com.quest.collections.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, String> employeeMap = new HashMap<>();

        employeeMap.put(111, "Alice");
        employeeMap.put(112, "Bob");
        employeeMap.put(113, "Charlie");
        employeeMap.put(114, "David");
        employeeMap.put(115, "Eva");

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
