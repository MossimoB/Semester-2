package org.mossimo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public abstract class Pet {
    protected String id;
    protected String name;
    protected int age;
    protected Gender gender;

    public Pet(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
