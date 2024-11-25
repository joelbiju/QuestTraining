package com.quest.exceptionErrorsExample;

public class Employee {
    protected String name;
    protected int age;
    protected double salary;

    public Employee(String name, int age, double salary) throws InvalidInputException {

        if (age < 18) {
            throw new InvalidInputException("Age must be  18 or older.",name);
        }
        if (salary < 0) {
            throw new InvalidInputException("Salary cannot be negative.",name);
        }
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public final void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }

    @Override
    public String toString() {
        return "Employee [Name=" + name + ", Age=" + age + ", Salary=" + salary + "]";
    }
}
