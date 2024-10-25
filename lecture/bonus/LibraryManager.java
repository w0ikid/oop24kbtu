package bonus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Абстрактный класс: Book
abstract class Book {
    private String title;
    private String author;
    private double price;

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getCategory();

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Price: " + price + ", Category: " + getCategory();
    }
}

// Класс FictionBook
class FictionBook extends Book {
    public FictionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public String getCategory() {
        return "Fiction";
    }
}

// Класс NonFictionBook
class NonFictionBook extends Book {
    public NonFictionBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public String getCategory() {
        return "Non-fiction";
    }
}

// Класс ChildrenBook (наследуется от FictionBook)
class ChildrenBook extends FictionBook {
    public ChildrenBook(String title, String author, double price) {
        super(title, author, price);
    }

    @Override
    public String getCategory() {
        return "Children's Fiction";
    }
}

// Класс FileManager для работы с файлами
class FileManager {

    public static void saveBooksToFile(List<Book> books, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Book book : books) {
                writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.getPrice() + "," + book.getCategory());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public static List<Book> loadBooksFromFile(String filename) {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Reading line: " + line);  // Отладочный вывод
                String[] details = line.split(",");
                if (details.length != 4) {
                    System.out.println("Skipping malformed line: " + line);
                    continue;
                }

                String title = details[0];
                String author = details[1];
                double price = Double.parseDouble(details[2]);
                String category = details[3];

                Book book;
                switch (category) {
                    case "Fiction":
                        book = new FictionBook(title, author, price);
                        break;
                    case "Non-fiction":
                        book = new NonFictionBook(title, author, price);
                        break;
                    case "Children's Fiction":
                        book = new ChildrenBook(title, author, price);
                        break;
                    default:
                        System.out.println("Unknown category: " + category);
                        continue;
                }
                books.add(book);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return books;
    }
}

// Основной класс программы LibraryManager
public class LibraryManager {
    private List<Book> books;

    public LibraryManager() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void saveBooks(String filename) {
        FileManager.saveBooksToFile(books, filename);
    }

    public void loadBooks(String filename) {
        books = FileManager.loadBooksFromFile(filename);
    }

    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books to display.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();

        // Добавляем книги
        manager.addBook(new FictionBook("The Great Gatsby", "F. Scott Fitzgerald", 10.99));
        manager.addBook(new NonFictionBook("Sapiens", "Yuval Noah Harari", 15.99));
        manager.addBook(new ChildrenBook("Harry Potter", "J.K. Rowling", 9.99));

        // Сохраняем книги в файл
        manager.saveBooks("books.txt");

        // Загружаем книги из файла
        manager.loadBooks("books.txt");

        // Отображаем все книги
        manager.displayBooks();
    }
}
