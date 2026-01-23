package org.example;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
public class Dog {
    // fields
    private String id;
    private String name;
    private int age;
    private Cats.Gender gender;

    private static int nextId = 1;

    public Dog(String name, int age, Cats.Gender gender) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    // enum
    public enum Gender {
        MALE, FEMALE
    }
}
