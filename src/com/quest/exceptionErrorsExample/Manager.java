package com.quest.exceptionErrorsExample;

public class Manager extends Employee{
    protected int teamSize;

    public Manager(String name, int age, double salary, int teamSize) throws InvalidInputException {
        super(name, age, salary);
        if (teamSize < 1){
            throw new InvalidInputException("Team size must be 1 or greater.",name);
        }
        this.teamSize = teamSize;
    }

    @Override
    public String toString() {
        return "Manager [Name=" + name + ", Age=" + age + ", Salary=" + salary + ", TeamSize=" + teamSize + "]";
    }
}
