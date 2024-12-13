package com.quest.case_study.employee_data_analysis;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        Employee e1 = new Employee(101, "Alice", "HR", 55000);
        Employee e2 = new Employee(102, "David", "IT", 60000);
        Employee e3 = new Employee(103, "Charlie", "HR", 32000);
        Employee e4 = new Employee(105, "Bob", "Finance", 25000);

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        EmployeeOperations ops = new EmployeeOperations();
        Map<String, Set<String>> groupByDepartments = ops.getEmployeeDeptMap(employees);

        System.out.println(groupByDepartments);

        List<String> employeeWithFixedSalary = ops.getEmployeesWithFixedSalary(employees, 50000);
        System.out.println("Employee with salary > 50000:");
        System.out.println(employeeWithFixedSalary);

        System.out.println("Employee with highest salary:"+ ops.getEmployeeWithHighSalary(employees).getName());


    }
}
