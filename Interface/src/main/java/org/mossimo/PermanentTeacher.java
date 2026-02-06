package org.mossimo;

public class PermanentTeacher extends Teacher implements Park {
    public PermanentTeacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void register() {
        System.out.println("The cost will be removed from your next payment.");
    }
}
