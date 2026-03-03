package org.mossimo;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Teacher {
    private String name;
    private int age;
    private Gender gender;
    private int experience;
    private double salary;

    public enum Gender {
        MALE, FEMALE
    }
}
