package org.example;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Library {
    private List<Book> books; // a list of books, NOT array

    public Library() {
        this.books = new ArrayList<>();
    }
}
