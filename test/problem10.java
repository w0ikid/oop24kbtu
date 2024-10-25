package test;

public class problem10 {
    public static void main(String[] args) {
        // Создаем объект Child и вызываем метод display()
        Child child = new Child("SomeName");
        child.display();  // Выводим имя из Parent и Child
    }
}

class Parent {
    private String name;

    // Конструктор для инициализации поля name
    public Parent(String name) {
        this.name = name;
    }

    // Метод display(), который выводит имя родителя
    public void display() {
        System.out.println(name + " Parent");
    }
}

class Child extends Parent {
    private String name;

    // Конструктор для инициализации имени Child и вызова конструктора Parent
    public Child(String name) {
        super(name + " (from Parent)");  // Инициализация поля name в родительском классе
        this.name = name;
    }

    // Переопределяем метод display() и вызываем метод родителя через super
    @Override
    public void display() {
        super.display();  // Вызываем метод display() родителя
        System.out.println(name + " Child");
    }
}
