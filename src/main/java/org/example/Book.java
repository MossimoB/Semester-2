package org.example;

public class Book {
    private String id;
    private String title;
    private Author[] authors; // author array

    private static int nextId = 1;

    public Book(String name, Author[] authors) {
        this.id = String.format("%04d", nextId++);
        this.title = title;
        this.authors = authors;
    }
}
