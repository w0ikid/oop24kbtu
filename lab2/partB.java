package lab2;

/**
 * partB
 */
public class partB {
    public static void main(String[] args) {
        LibraryItem[] listOfItems = new LibraryItem[3];

        listOfItems[0] = new Book("USA", "oil", 1975, 100);
        listOfItems[1] = new Book("A", "region", 2022, 100);
        listOfItems[2] = new Book("Kazak", "oil", 1975, 100);

        for (LibraryItem libraryItem : listOfItems) {
            System.out.println(libraryItem.getItemDetails());
        }
    }
}

abstract class LibraryItem {
    private String title;
    private String author;
    private int publicationYear;

    public LibraryItem(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public abstract String getItemDetails();

    @Override
    public String toString() {
        return "tutle: " + title + " author: " + author + " year: " + publicationYear;
    }
}

class Book extends LibraryItem {
    private int numberOfPages;

    public Book(String title, String author, int publicationYear, int numberOfPages) {
        super(title, author, publicationYear);
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
    
    @Override
    public String getItemDetails() {
        return "Book - " + toString() + ", Pages: " + numberOfPages;
    }
}



