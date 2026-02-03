package org.mossimo;

public class Main {
    public static void main(String[] args) {
        Pet pet = new Cat("Snow", 3, 2);
        
        Object object1 = new Cat("Snow", 3, 2);
        Object object2 = new Dog("Snow", 3, false);

        System.out.println(pet.equals(object1)); // polymorphism
    }
}
