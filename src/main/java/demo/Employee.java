package demo;

public class Employee {
    private String name;
    private String department;
    private double salary;
    private int experience; // in years

    // Constructor, Getters, Setters

    public Employee(String name, String department, double salary, int experience) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.experience = experience;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public int getExperience() { return experience; }

    @Override
    public String toString() {
        return name + " (" + department + ", " + experience + " yrs)";
    }
}
