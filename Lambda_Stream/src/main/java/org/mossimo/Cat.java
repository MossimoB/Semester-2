package org.mossimo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Comparator;

@Getter
@Setter
@ToString
public class Cat {
    private String name;
    private int age;
    private int price;

    public Cat(String name, int age, int price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }

    public static class CatComparator implements Comparator<Cat> {

        @Override
        public int compare(Cat o1, Cat o2) {
            return o2.age - o1.age;
        }
    }
}
