package com.quest.streams_api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Operations {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 30, "IT", 70000, 5),
                new Employee(2, "Bob", 40, "Finance", 80000, 10),
                new Employee(3, "Charlie", 35, "IT", 120000, 8),
                new Employee(4, "Diana", 28, "HR", 60000, 3),
                new Employee(5, "Eve", 25, "Marketing", 50000, 2)
        );

        //sorting based on salary
        System.out.println("\n---- Sorted based on Salary ----");
        List<Employee> sortedSalary =  employees.stream().sorted(Comparator.comparing(Employee::getSalary)).toList();
        sortedSalary.forEach(System.out::println);

        //filtering by departments
        System.out.println("\n---- Filtering by Department ----");
        List<Employee> filterDept = employees.stream().filter(emp -> "IT".equals(emp.getDepartment())).toList();
        filterDept.forEach(System.out::println);

        //finding max salary and min salary employee
        System.out.println("\n---- Min salary ----");
        Optional<Employee> maxSalary = employees.stream().min(Comparator.comparing(Employee::getSalary));
        maxSalary.ifPresent(System.out::println);

        System.out.println("\n---- Max salary ----");
        Optional<Employee> minSalary = employees.stream().max(Comparator.comparing(Employee::getSalary));
        minSalary.ifPresent(System.out::println);

        //skipping few entries
        System.out.println("\n---- After skipping few entries ----");
        List<Employee> skippedEntries = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(3).toList();
        skippedEntries.forEach(System.out::println);

        Optional<Double> totalSalary = employees.stream().map(Employee::getSalary).reduce((s1, s2) -> s1 + s2);
        totalSalary.ifPresent(System.out::println);
        

    }
}
