package org.mossimo;

import lombok.Getter;
import lombok.ToString;

@ToString(callSuper = true)
@Getter
public class Cat extends Pet {
    private int cute;

    private static int nextId = 1;

    public Cat(String id, String name, int age, Gender gender, int cute) {
        super(id, name, age, gender);
        this.cute = cute;
    }

    public Cat(String name, int age, Gender gender, int cute) {
        super(name, age, gender);
        this.id = String.format("%04d", nextId++);
        this.cute = cute;
    }
}
