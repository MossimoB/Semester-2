package org.example;

public class Cats {
    // fields
    private String id;
    private String name;
    private int age;
    private Gender gender;

    private static int nextId = 1;

    // no arguments constructor (default constructor)
    public Cats() {
        this.id = null;                                            // must give defaults values to each field
        this.name = null;
        this.age = 0;
        this.gender = null;
    }

    public Cats(String name, int age, Gender gender) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // ALL THIS IS WITHOUT LOMBOK
    @Override
    public boolean qeuals(Object 0) {
        if (o == null || getClass() != 0.getClass()) return false;
        Cats cats = (Cats) o;
        return age == cats.age && Objects.equals(id, cats.equals());
        // code not done btw
    }

    // all arguments constructor
    public Cats(String id, String name, int age, Gender gender) {
        this.id = id;                                            // all fields must be unique
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // enum
    public enum Gender {
        MALE, FEMALE
    }
}
