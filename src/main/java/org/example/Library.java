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

    /**
     * add a new book to the books of the library
     * @param book the new book to be added
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * searches books that contains a keyword
     * @param keyword the keyword to be searched
     * @return the list of books which contain the book
     */
    public List<Book> searchBooks(String keyword) {
        List<Book> result = new ArrayList<>();

        // here is where you would go through all the books
        // that are stored in the library

        // searches for the book
        bookLoop: for (Book book : books) {
            // searches using the title
            String title = book.getTitle().toLowerCase();  // changes title to lowercase
            if (title.contains(keyword)) {
                result.add(book); // if the title has the word, add the book
                continue; // continue searching for other matches
            }

            // searches using the author
            Author[] authors = book.getAuthors();
            for (Author author : authors) {
                String findAuthor = author.getName().toLowerCase(); // changes author to lowercase
                if (name.contains(keyword)) {
                    result.add(book); // if the author had the keyword, add the book
                    continue bookLoop; // without bookLoop, continue is useless because it only
                                       // continues the inner loop
                }
            }

        }

        return result;
    }
}
