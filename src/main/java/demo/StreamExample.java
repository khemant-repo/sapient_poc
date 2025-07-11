package demo;

import java.util.*;
import java.util.stream.*;

public class StreamExample {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "IT", 80000, 5),
            new Employee("Bob", "Finance", 95000, 7),
            new Employee("Charlie", "IT", 85000, 10),
            new Employee("David", "HR", 70000, 3),
            new Employee("Eve", "Finance", 99000, 12)
        );

        // 1. Employee with maximum experience
        Optional<Employee> maxExperienceEmp = employees.stream()
            .max(Comparator.comparingInt(Employee::getExperience));

        maxExperienceEmp.ifPresent(emp ->
            System.out.println("Most experienced employee: " + emp)
        );

        // 2. Average salary by department
        Map<String, Double> avgSalaryByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)
            ));

        System.out.println("Average Salary by Department:");
        avgSalaryByDept.forEach((dept, avgSalary) ->
            System.out.println(dept + ": " + avgSalary)
        );
    }
}
