package org.mossimo;

/**
 * INHERITANCE EXAMPLE IN JAVA
 * ------------------------------------------------------------
 * Inheritance allows one class (child/subclass) to reuse code
 * from another class (parent/superclass).
 *
 * Key idea: "is-a" relationship.
 * Example: Dog IS-A Animal.
 */
class Animal {
    // This method belongs to the parent class
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

/**
 * Dog extends Animal.
 * This means Dog inherits all NON-private members of Animal.
 */
class Dog extends Animal {

    // Dog has its own unique behavior
    void bark() {
        System.out.println("Dog barks");
    }
}

/**
 * Main class to test inheritance
 */
public class Inheritance {
    public static void main(String[] args) {

        // Create a Dog object
        Dog d = new Dog();

        // Inherited method from Animal
        d.makeSound();

        // Dog's own method
        d.bark();
    }
}
