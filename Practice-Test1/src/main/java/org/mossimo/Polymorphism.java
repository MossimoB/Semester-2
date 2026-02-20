package org.mossimo;

/**
 * POLYMORPHISM EXAMPLE
 * ------------------------------------------------------------
 * Polymorphism = "many forms"
 *
 * In Java, the SAME method call can behave differently
 * depending on the object's actual type at runtime.
 */

class Pet {
    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Cat extends Pet {

    /**
     * @Override tells the compiler we are replacing
     * the parent version of makeSound().
     */
    @Override
    void makeSound() {
        System.out.println("Meow");
    }
}

public class Polymorphism {
    public static void main(String[] args) {

        /**
         * IMPORTANT:
         * Reference type = Pet
         * Object type = Cat
         *
         * Java decides at RUNTIME which method to run.
         */
        Pet p = new Cat();

        // Calls Cat's version, not Pet's
        p.makeSound();
    }
}
