package org.mossimo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Object object1 = new Cat("Snow", 3, 2);
        Object object2 = new Dog("Snow", 3, false);

        List<Pet> pets = new ArrayList<>();

        // upper casting
        pets.add(new Cat("Snow", 3, 2));
        pets.add(new Dog("Snow", 3, false));
        pets.add(new Pet("Snow", 3)); // this line won't work if Pet class is abstract
                                                 // because the class cannot contain objects if abstract

        for (Pet pet : pets) {
            pet.makeSound();    // polymorphism
        }
    }
}
