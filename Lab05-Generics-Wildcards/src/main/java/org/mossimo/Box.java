package org.mossimo;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Pet> {
    protected List<T> petList;

    public Box() {
        this.petList = new ArrayList<>();
    }

    public void add(T pet) {
        petList.add(pet);
    }
}
