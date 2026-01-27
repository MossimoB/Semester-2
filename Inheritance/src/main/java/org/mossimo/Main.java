package org.mossimo;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("snow", 3, 2);
        System.out.println(cat);

        Dog dog = new Dog("rosco", 12, true);
        System.out.println("\n" + dog);
    }
}