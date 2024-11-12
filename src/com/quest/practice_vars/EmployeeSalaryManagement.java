package com.quest.practice_vars;

import java.util.Scanner;

public class EmployeeSalaryManagement {

    public static class Employee {
        String name;
        double baseSalary;
        double[] monthlySalaries = new double[12];
        double totalSalary;
        double avgMonthlySalary;
        double bonus;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfEmployees;
        while (true) {
            System.out.print("Enter the number of employees: ");
            if (sc.hasNextInt()) {
                numberOfEmployees = sc.nextInt();
                if (numberOfEmployees > 0) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a positive integer.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next();
            }
        }
        double totalAverageSalary = 0;
        Employee[] employees = new Employee[numberOfEmployees];

        //calling the method
        totalAverageSalary = employeeDetails(numberOfEmployees, employees, totalAverageSalary);

        // Calling the method to print salary details
        printEmployeeSalaryReport(numberOfEmployees, employees, totalAverageSalary);

    }

    //method to get and calculate salary report
    static double employeeDetails(int numberOfEmployees, Employee[] employees, double totalAverageSalary) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < numberOfEmployees; i++) {
            employees[i] = new Employee();
            //method to get names
            getName(employees, i, sc);
            while (true) {
                System.out.print("Enter the base salary of " + employees[i].name + ": ");
                if (sc.hasNextDouble()) {
                    employees[i].baseSalary = sc.nextDouble();
                    if (employees[i].baseSalary > 0) {
                        break;
                    } else {
                        System.out.println("Invalid input! Base salary cannot be zero.");
                    }
                } else {
                    System.out.println("Invalid input! Please enter a valid number.");
                    sc.next();
                }
            }
            for (int j = 0; j < employees[i].monthlySalaries.length; j++) {
                while (true) {
                    System.out.print("Enter salary for month " + (j + 1) + " (0-100000): ");
                    if (sc.hasNextDouble()) {
                        employees[i].monthlySalaries[j] = sc.nextDouble();
                        if (employees[i].monthlySalaries[j] > 0) {
                            break;
                        } else {
                            System.out.println("Invalid input! Salary cannot be zero.");
                        }
                    } else {
                        System.out.println("Invalid input! Please enter a valid number.");
                        sc.next();
                    }
                }
                employees[i].totalSalary += employees[i].monthlySalaries[j];
                sc.nextLine();
            }

            employees[i].avgMonthlySalary = employees[i].totalSalary / employees[i].monthlySalaries.length;
            totalAverageSalary += employees[i].avgMonthlySalary;
            employees[i].bonus = employees[i].totalSalary - (employees[i].baseSalary * employees[i].monthlySalaries.length);
        }
        return totalAverageSalary;
    }

    private static void getName(Employee[] employees, int i, Scanner sc) {
        while (true) {
            System.out.print("Enter the name of employee " + (i + 1) + ": ");
            employees[i].name = sc.nextLine();
            if (!employees[i].name.isEmpty()) {
                break;
            } else {
                System.out.println("Invalid input! Name cannot be empty.");
            }
        }
    }

    // Method to print employee salary details
    static void printEmployeeSalaryReport(int numberOfEmployees, Employee[] employees, double totalAverageSalary) {
        System.out.println("\n---Employee Salary Report---");
        for (int i = 0; i < numberOfEmployees; i++) {
            System.out.println("Employee name: " + employees[i].name);
            System.out.println("Base Salary: " + employees[i].baseSalary);
            System.out.println("Monthly Salary Breakdown: ");
            for (int j = 0; j < employees[i].monthlySalaries.length; j++) {
                System.out.println("Month " + (j + 1) + " :" + employees[i].monthlySalaries[j]);
            }
            System.out.println("Total Salary of the year: " + employees[i].totalSalary);
            System.out.println("Average monthly Salary: " + Math.round(employees[i].avgMonthlySalary));
            System.out.println("Bonus: " + employees[i].bonus);
        }
        System.out.println("Average Salary for All Employees: " + Math.round(totalAverageSalary));
        System.out.println("Thank you for using the Employee Salary Management System.");
    }

}
