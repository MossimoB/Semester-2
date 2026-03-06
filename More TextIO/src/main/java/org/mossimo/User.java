package org.mossimo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
public class User {
    protected String id;
    protected String name;
    protected int age;

    public User(String id, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
