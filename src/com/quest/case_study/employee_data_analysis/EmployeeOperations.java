package com.quest.case_study.employee_data_analysis;

import java.util.*;

public class EmployeeOperations {

    public Map<String, Set<String>> getEmployeeDeptMap(List<Employee> employees) {
        Map<String, Set<String>> employeeDeptMap = new HashMap<>();
        for (Employee employee : employees) {
            String deptName = employee.getDepartment();

            if (!employeeDeptMap.containsKey(deptName)) {
                employeeDeptMap.put(deptName, new HashSet<>());
            }
            employeeDeptMap.get(deptName).add(employee.getName());
        }
        return employeeDeptMap;
    }

    public List<String> getEmployeesWithFixedSalary(List<Employee> employees, double salary) {
        List<String> employeesWithFixedSalary = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getSalary() > salary) {
                employeesWithFixedSalary.add(employee.getName());
            }
        }
        return employeesWithFixedSalary;
    }

    public Employee getEmployeeWithHighSalary(List<Employee> employees) {
        Optional<Employee> maxSalaryEmployee = employees.stream().max(Comparator.comparing(Employee::getSalary));
        return maxSalaryEmployee.orElse(null);
    }


}
