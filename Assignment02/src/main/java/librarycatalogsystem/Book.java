package librarycatalogsystem;

import lombok.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class Book implements Comparable<Book> {
    private String title;
    private String author;
    private int publishYear;

    public Book(String title, String author, int publishYear) {
        this.title = title;
        this.author = author;
        this.publishYear = publishYear;
    }

    @Override
    public String toString() {
        return title + " - " + author + " (" + publishYear + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book b)) {
            return false;
        }

        return publishYear == b.publishYear &&
                title.equals(b.title) &&
                author.equals(b.author);
    }

    @Override
    public int compareTo(Book o) {
        if (this.publishYear != o.publishYear) {
            return this.publishYear - o.publishYear;
        }

        return this.title.compareTo(o.title);
    }

    public static void sortAndDisplayBooks() {
        List<Book> books = new ArrayList<>();

        // example books
        books.add(new Ebook("Red", "Alice", 2020, 5.5));
        books.add(new PrintedBook("Blue", "Bob", 2021, 400));
        books.add(new Ebook("Yellow", "Charlie", 2022, 3.2));
        books.add(new PrintedBook("Green", "David", 2023, 350));
        books.add(new Ebook("Pink", "Eddy", 2024, 2.8));

        Collections.sort(books);

        for (Book book : books) {
            System.out.println(book);
        }
    }
}
