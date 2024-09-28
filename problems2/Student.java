package problems2;

public class Student {
    private String name;
    private int id;
    private int yearOfStudy;
    private int grade;  // добавляем поле для хранения оценки

    // Конструктор с тремя параметрами (имя, id и оценка)
    public Student(String nameN, int id, int grade) {
        this.name = nameN;
        this.id = id;
        this.yearOfStudy = 1; // Инициализация года обучения
        this.grade = grade;    // Инициализация оценки
    }

    // Метод для получения имени студента
    public String GetName() {
        return name;
    }

    // Метод для получения id студента
    public int GetId() {
        return id;
    }

    // Метод для получения года обучения студента
    public int GetYearOfStudy() {
        return yearOfStudy;
    }

    // Метод для увеличения года обучения
    public void incrementYearOfStudy() {
        yearOfStudy++;
    }

    // Метод для получения оценки студента
    public int GetGrade() {
        return grade;
    }

    // Метод для печати информации о студенте
    public void PropertyPrint() {
        System.out.printf("Student %s (id: %d) is in year %d and has a grade of %d\n", name, id, yearOfStudy, grade);
    }
}
