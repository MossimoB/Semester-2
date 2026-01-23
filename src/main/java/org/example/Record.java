package org.example;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@EqualsAndHashCode
@ToString
@Getter
@Setter // usually this wouldnt be on top because you dont want to be able to
        // manually set the time or id
public class Record {
    private String id;
    private Book book; // have to specify the book
    private LocalDateTime borrowedTime; // specifies the exact date and time
    private LocalDateTime returnedTime;

    private static int nextId = 1;

    public Record(Book book) {
        this.id = String.format("04d", nextId++);
        this.book = book;
        this.borrowedTime = LocalDateTime.now();
        this.returnedTime = null; // null because no time yet
    }
}
