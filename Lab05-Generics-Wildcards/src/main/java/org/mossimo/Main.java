package org.mossimo;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Michael");
        Dog dog = new Dog("Johnny");

        Box<Cat> Cat = new Box<>();
        Box<Dog> Dog = new Box<>();

        Cat.add(cat);
        Dog.add(dog);
    }

    // Wildcard
    public static double calcAvg(List<? extends Number> numbers) {
        double sum = 0;

        for(Number num : numbers) {
            sum += num.doubleValue();
        }

        return sum / numbers.size();
    }
}
