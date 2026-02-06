package org.mossimo;

public class RegularStudent extends Student {
    public RegularStudent(String name, int age) {
        super(name, age);
    }

    public void register() {
        System.out.println("Please proceed with the payment in the next 7 days.");
    }
}
