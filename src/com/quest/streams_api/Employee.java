package com.quest.streams_api;

public class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private double salary;
    private int yearExperience;

    public Employee(int id, String name, int age, String department, double salary, int yearExperience) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.yearExperience = yearExperience;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public int getYearExperience() {
        return yearExperience;
    }

    @Override
    public String toString() {
        return "Employee [id=" +
                id + ", name=" + name + ", age=" +
                age + ", department=" + department + ", salary=" +
                salary + ", yearExperience=" + yearExperience + "]";
    }
}
