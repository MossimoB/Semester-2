package employeemanagementsystem;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class FullTimeEmployee extends Employee implements BonusEligible {
    private int performanceRate;

    // constructor
    public FullTimeEmployee(String name, double baseSalary, int performanceRate) {
        super(name, baseSalary);   // sends data to Employee
        this.performanceRate = performanceRate;
    }

    // from BonusEligible interface
    @Override
    public double calcBonus() {
        return getBaseSalary() * (performanceRate >= 8 ? 0.10 : 0.05);
    }

    // override the abstract method
    @Override
    public double calculateSalary() {
        return getBaseSalary() + calcBonus();
    }

    // toString
    @Override
    public String toString() {
        return super.toString()
                + ", Performance Rate: " + performanceRate
                + ", Salary: " + calculateSalary();
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        return o instanceof FullTimeEmployee f &&
                performanceRate == f.performanceRate;
    }
}
