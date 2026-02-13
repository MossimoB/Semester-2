package librarycatalogsystem;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class PrintedBook extends Book {
    private int numOfPages;

    public PrintedBook(String title, String author, int publishYear, int numOfPages) {
        super(title, author, publishYear);
        this.numOfPages = numOfPages;
    }

    @Override
    public String toString() {
        return super.toString() + ", Pages: " + numOfPages;
    }

    @Override
    public int compareTo(Book o) {
        if (o instanceof PrintedBook p) {
            // descending
            return p.getNumOfPages() - this.numOfPages;
        }
        return super.compareTo(o);
    }
}
