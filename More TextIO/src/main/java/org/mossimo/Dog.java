package org.mossimo;

import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
public class Dog extends Pet {
    private boolean dangerous;

    private static int nextId = 1;

    public Dog(String id, String name, int age, Gender gender, boolean dangerous) {
        super(id, name, age, gender);
        this.dangerous = dangerous;
    }

    public Dog(String name, int age, Gender gender, boolean dangerous) {
        super(name, age, gender);
        this.id = String.format("%04d", nextId++);
        this.dangerous = dangerous;
    }
}
