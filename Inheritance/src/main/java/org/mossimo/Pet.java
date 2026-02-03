package org.mossimo;

// This is the Superclass of Dog and Cat
// Dog is a Subclass of Pet
// Cat is a Subclass of Pet

import java.util.Objects;

// Don't have to write extends Object because it's there by default
// Class Object is the root of the class hierarchy
// Every class has Object as a superclass
// All objects, including arrays, implement the methods of this class
public class Pet extends Object {
    // No need to write these fields in the subclasses
    // This is inheritance
    // Since the parent class (Pet) has it, so will the child classes (Dog, Cat)
    private String id;
    private String name;
    private int age;

    private static int nextId = 1;

    public Pet(String name, int age) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
        this.age = age;
    }

    // if we want abstract to work, the class needs to be abstract too
    // public abstract class Pet extends Object
    public abstract void makeSound();

    public abstract double fake();

    // Since wrote this in Pet class, both Cat and Dog have it too
    // fakeMethod with NO parameter
    public void fakeMethod() {
        System.out.println("fake");
    }


    // TO GET THE FOLLOWING, USE ALT + INSERT
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && Objects.equals(id, pet.id) && Objects.equals(name, pet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Pet.nextId = nextId;
    }
}
