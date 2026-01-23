package org.example;

public class Author {
    private String id;
    private String name;
    private String nationality;

    private static int nextId = 1;

    public Author(String name, String nationality) {
        this.id = String.format("%04d", nextId++);
        this.name = name;
        this.nationality = nationality;
    }
}
