package employeemanagementsystem;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class PartTimeEmployee extends Employee {
    private int workHour;
    private double hourlyRate;

    // constructor
    public PartTimeEmployee(String name, double baseSalary, int workHour, double hourlyRate) {
        super(name, baseSalary);
        this.workHour = workHour;
        this.hourlyRate = hourlyRate;
    }

    // overrides the abstract method
    @Override
    public double calculateSalary() {
        return workHour * hourlyRate;
    }

    // toString
    @Override
    public String toString() {
        return super.toString()
                + ", Work Hour: " + workHour
                + ", Hourly Rate: " + hourlyRate
                + ", Salary: " + calculateSalary();
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        return o instanceof PartTimeEmployee p &&
                workHour == p.workHour &&
                Double.compare(hourlyRate, p.hourlyRate) == 0;
    }
}
