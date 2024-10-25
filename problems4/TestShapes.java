package problems4;

import java.util.Vector;

// Определение перечисления для цвета
enum Color {
    RED, GREEN, BLUE, YELLOW, BLACK
}

// Абстрактный класс Shape
abstract class Shape {
    protected int position;
    protected Color color;

    // Конструктор абстрактного класса
    public Shape(int position, Color color) {
        this.position = position;
        this.color = color;
    }

    // Абстрактный метод draw()
    public abstract void draw();
}

// Класс Circle, наследующий Shape
class Circle extends Shape {
    private double radius;

    public Circle(int position, Color color, double radius) {
        super(position, color);
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Circle at position " + position + " with color " + color + " and radius " + radius);
    }
}

// Класс Rectangle, наследующий Shape
class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle(int position, Color color, double width, double height) {
        super(position, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Rectangle at position " + position + " with color " + color + " and dimensions " + width + "x" + height);
    }
}

// Класс Triangle, наследующий Shape
class Triangle extends Shape {
    private double base;
    private double height;

    public Triangle(int position, Color color, double base, double height) {
        super(position, color);
        this.base = base;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing Triangle at position " + position + " with color " + color + " and base " + base + " and height " + height);
    }
}

public class TestShapes {
    public static void main(String[] args) {
        Vector<Shape> shapes = new Vector<>();

        // Добавляем разные фигуры в вектор
        shapes.add(new Circle(1, Color.RED, 5.0));
        shapes.add(new Rectangle(2, Color.GREEN, 4.0, 3.0));
        shapes.add(new Triangle(3, Color.BLUE, 6.0, 4.0));

        // Рисуем все фигуры
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}