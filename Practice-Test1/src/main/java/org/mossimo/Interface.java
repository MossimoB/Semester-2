package org.mossimo;

/**
 * INTERFACE EXAMPLE
 * ------------------------------------------------------------
 * An interface is a CONTRACT.
 *
 * It tells classes:
 * "If you implement me, you MUST implement my methods."
 */

interface Flyable {

    /**
     * Methods in interfaces are PUBLIC and ABSTRACT by default.
     */
    void fly();
}

/**
 * Bird agrees to the Flyable contract.
 */
class Bird implements Flyable {

    /**
     * MUST be public when implementing interface methods.
     */
    @Override
    public void fly() {
        System.out.println("Bird is flying");
    }
}

public class Interface {
    public static void main(String[] args) {

        Flyable f = new Bird(); // polymorphism with interfaces
        f.fly();
    }
}
