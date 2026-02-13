package librarycatalogsystem;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Ebook extends Book {
    private double fileSizeMB;

    public Ebook(String title, String author, int publishYear, double fileSizeMB) {
        super(title, author, publishYear);
        this.fileSizeMB = fileSizeMB;
    }

    @Override
    public String toString() {
        return super.toString() + ", File Size: " + fileSizeMB + " MB";
    }

    @Override
    public int compareTo(Book o) {
        if (o instanceof Ebook e) {
            return Double.compare(this.fileSizeMB, e.fileSizeMB);
        }
        return super.compareTo(o);
    }
}
