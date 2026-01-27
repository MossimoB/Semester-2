package org.mossimo;

// Cat is a Subclass of Pet

import java.util.Objects;

public class Cat extends Pet { // extends means that Pet is parent class
    private int cuteLevel; // unique to Cat class

    // need to add ALL fields in this constructor
    public Cat(String name, int age, int cuteLevel) {
        super(name, age); // This calls the Pet class (don't write Pet, write super)
                          // Rather than initializing this.name and this.age ,
                          // We can call on the Pet class
        this.cuteLevel = cuteLevel;
    }

    // fakeMethod with ONE parameter
    // This method DOES NOT replace the fakeMethod in Pet
    // This is called Overload, not Override
    public void fakeMethod(int num) {
        System.out.println(num);
    }

    // Here we can use Override because it has the same parameters (none in this case)
    @Override
    public void fakeMethod() {
        System.out.println("cat-version fake method");
    }


    // TO GET THE FOLLOWING, USE ALT + INSERT
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cat cat = (Cat) o;
        return cuteLevel == cat.cuteLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cuteLevel);
    }

    @Override
    public String toString() {
        return "Cat{" +
                super.toString() + // NEED TO ADD MANUALLY
                "cuteLevel=" + cuteLevel +
                '}';
    }

    public int getCuteLevel() {
        return cuteLevel;
    }

    public void setCuteLevel(int cuteLevel) {
        this.cuteLevel = cuteLevel;
    }
}
