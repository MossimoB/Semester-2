package org.mossimo;

import java.util.*;

/**
 * COMPARABLE vs COMPARATOR
 * ------------------------------------------------------------
 * Comparable:
 *   - Inside the class
 *   - Defines natural ordering
 *
 * Comparator:
 *   - External class/object
 *   - Allows multiple sorting strategies
 */

class Student implements Comparable<Student> {
    String name;
    int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    /**
     * Natural ordering: by grade
     */
    @Override
    public int compareTo(Student other) {
        return this.grade - other.grade;
    }

    @Override
    public String toString() {
        return name + " (" + grade + ")";
    }
}

/**
 * Custom comparator: sort by name
 */
class NameComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
}

public class ComparableAndComparator {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<>();
        list.add(new Student("Charlie", 85));
        list.add(new Student("Alice", 92));
        list.add(new Student("Bob", 78));

        // Sort using Comparable (by grade)
        Collections.sort(list);
        System.out.println("Sort by grade: " + list);

        // Sort using Comparator (by name)
        Collections.sort(list, new NameComparator());
        System.out.println("Sort by name: " + list);
    }
}
