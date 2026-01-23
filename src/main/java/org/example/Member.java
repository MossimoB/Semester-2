package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Member {
    private String id;
    private String name;
    private List<Record> records; // every member must have his own list of records

    private static int nextId = 1;

    public Member(String name, List<Record> records) {
        this.id = String.format("04d", nextId++);
        this.name = name;
        this.records = new ArrayList<>();
    }

    /**
     * borrows a book and adds a new record to the records
     * @param book the book to be borrowed
     */
    public void borrowBook(Book book) {
        records.add(new Record(book));
    }

    /**
     * returns a book and updates the record
     * @param book the book to be returned
     */
    public void returnBook(Book book) {
        for (int i = records.size() - 1; i >= 0; i--) {
            if (records.get(i).equals(book) && records.get(i) == null) {
                records.get(i).setReturnedTime(LocalDateTime.now());
            }
        }
    }
}
