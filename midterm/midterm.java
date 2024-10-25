import java.util.ArrayList;

public class midterm {
    public static void main(String[] args) {
        // Создаем список элементов библиотеки
        ArrayList<LibraryItem> libraryItems = new ArrayList<>();

        // Добавляем книги и журналы в библиотеку
        libraryItems.add(new Book("The Great Gatsby", "123456789", "F. Scott Fitzgerald"));
        libraryItems.add(new Magazine("National Geographic", "987654321", 2023));

        // Выводим информацию о каждом элементе
        for (LibraryItem item : libraryItems) {
            item.displayinfo();
        }
    }
}

// Абстрактный класс LibraryItem
abstract class LibraryItem {
    private String title;
    private String ISBN;

    public LibraryItem(String title, String ISBN) {
        this.title = title;
        this.ISBN = ISBN;
    }

    // Абстрактный метод для вывода информации
    public abstract void displayinfo();

    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }
}

// Класс Book, который наследует LibraryItem
class Book extends LibraryItem {
    private String author;

    public Book(String title, String ISBN, String author) {
        super(title, ISBN); // Вызов конструктора суперкласса
        this.author = author; // Инициализация автора
    }

    @Override
    public void displayinfo() {
        System.out.println("Book Title: " + getTitle());
        System.out.println("ISBN: " + getISBN());
        System.out.println("Author: " + author);
    }

    public String getAuthor() {
        return author;
    }
}

// Класс Magazine, который наследует LibraryItem
class Magazine extends LibraryItem {
    private int issueNumber;

    public Magazine(String title, String ISBN, int issueNumber) {
        super(title, ISBN); // Вызов конструктора суперкласса
        this.issueNumber = issueNumber; // Инициализация номера выпуска
    }

    @Override
    public void displayinfo() {
        System.out.println("Magazine Title: " + getTitle());
        System.out.println("ISBN: " + getISBN());
        System.out.println("Issue Number: " + issueNumber);
    }

    public int getIssueNumber() {
        return issueNumber;
    }
}
