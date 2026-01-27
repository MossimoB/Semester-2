package org.mossimo;

// Dog is a Subclass of Pet

import java.util.Objects;

public class Dog extends Pet { // extends means that Pet is parent class
    private boolean dangerous; // unique to Dog class

    public Dog(String name, int age, boolean dangerous) {
        super(name, age); // This calls the Pet class (don't write Pet, write super)
                          // Rather than initializing this.name and this.age ,
                          // We can call on the Pet class
        this.dangerous = dangerous;
    }


    // TO GET THE FOLLOWING, USE ALT + INSERT
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Dog dog = (Dog) o;
        return dangerous == dog.dangerous;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dangerous);
    }

    @Override
    public String toString() {
        return "Dog{" +
                super.toString() + // NEED TO ADD MANUALLY
                "dangerous=" + dangerous +
                '}';
    }

    public boolean isDangerous() {
        return dangerous;
    }

    public void setDangerous(boolean dangerous) {
        this.dangerous = dangerous;
    }
}
