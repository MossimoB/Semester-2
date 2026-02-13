package org.mossimo;

import employeemanagementsystem.*;
import librarycatalogsystem.*;
import flexiblestudentcomparator.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Task 1: Employee Management
        System.out.println("=== Task 1: Employees ===\n");

        List<Employee> employees = new ArrayList<>();

        employees.add(new FullTimeEmployee("Alice", 5000, 9));
        employees.add(new FullTimeEmployee("Bob", 5500, 7));
        employees.add(new PartTimeEmployee("Charlie", 0, 80, 20));
        employees.add(new PartTimeEmployee("David", 0, 60, 25));

        for (Employee e : employees) {
            e.displayDetails();
        }

        // Task 2: Library Catalog
        System.out.println("\n\n=== Task 2: Books ===\n");
        Book.sortAndDisplayBooks();

        // Task 3: Flexible Student Comparator
        System.out.println("\n\n=== Task 3: Students ===\n");

        List<Student> students = new ArrayList<>();

        Student s1 = new Student("Alice", 20);
                s1.setScore(85.0);
                s1.setId("0102");
        Student s2 = new Student("Bob", 22);
                s2.setScore(85.0);
                s2.setId("0104");  // score tie with Alice
        Student s3 = new Student("Charlie", 19);
                s3.setScore(92.0);
                s3.setId("0101");
        Student s4 = new Student("David", 20);
                s4.setScore(85.0);
                s4.setId("0103");  // score tie with Alice, David younger tie-break

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        System.out.println("--- SCORE ---");
        Collections.sort(students, new Student.StudentComparator(Student.SortType.SCORE));
        students.forEach(System.out::println);

        System.out.println("\n--- NAME ---");
        Collections.sort(students, new Student.StudentComparator(Student.SortType.NAME));
        students.forEach(System.out::println);

        System.out.println("\n--- AGE ---");
        Collections.sort(students, new Student.StudentComparator(Student.SortType.AGE));
        students.forEach(System.out::println);

        System.out.println("\n--- ID ---");
        Collections.sort(students, new Student.StudentComparator(Student.SortType.ID));
        students.forEach(System.out::println);
    }
}
