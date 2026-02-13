package employeemanagementsystem;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public abstract class Employee {
    // fields
    private String id;
    private String name;
    private double baseSalary;

    private static int counter = 1;

    // constructor with name and baseSalary
    public Employee(String name, double baseSalary) {
        this.id = String.format("%04d", counter++);
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // abstract method
    public abstract double calculateSalary();

    // concrete method with toString()
    public void displayDetails() {
        System.out.println(this.toString());
    }

    // toString
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Base Salary: " + baseSalary;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Employee)) {
            return false;
        }

        Employee e = (Employee) o; {
            return id.equals(e.id);
        }
    }
}
