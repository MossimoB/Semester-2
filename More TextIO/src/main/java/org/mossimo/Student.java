package org.mossimo;

import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
public class Student extends User {
    private String department;

    private static int nextId = 1;

    public Student (String name, int age, String department) {
        super(name, age);
        this.id = String.format("%04d", nextId++);
        this.department = department;
    }
}
