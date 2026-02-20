package org.mossimo;

/**
 * ABSTRACT CLASS EXAMPLE
 * ------------------------------------------------------------
 * Abstract classes are PARTIALLY complete classes.
 *
 * Rules:
 * - Cannot create objects of abstract classes
 * - Can contain abstract methods (no body)
 * - Subclasses MUST implement abstract methods
 */

abstract class Shape {

    // Abstract method (no implementation)
    abstract double area();

    // Normal method (has implementation)
    void describe() {
        System.out.println("I am a shape.");
    }
}

/**
 * Circle must implement area()
 */
class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }
}

public class AbstractClass {
    public static void main(String[] args) {

        // Shape s = new Shape(); ❌ NOT allowed

        Circle c = new Circle(5);
        c.describe();
        System.out.println("Area = " + c.area());
    }
}
