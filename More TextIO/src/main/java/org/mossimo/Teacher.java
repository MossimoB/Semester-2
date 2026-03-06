package org.mossimo;

import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
public class Teacher extends User {
    private int experience;

    private static int nextId = 1;

    public Teacher(String id, String name, int age, int experience) {
        super(id, name, age);
        this.experience = experience;
    }

    public Teacher(String name, int age, int experience) {
        super(name, age);
        this.id = String.format("%04d", nextId++);
        this.experience = experience;
    }
}
