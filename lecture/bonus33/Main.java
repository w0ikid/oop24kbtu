abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract void makeSound();

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
}

interface CanFly {
    void fly();
}

interface CanSwim {
    void swim();
}

interface CanWalk {
    void walk();
}

class Bird extends Animal implements CanFly, CanWalk {

    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("chirk");
    }

    @Override
    public void fly() {
        System.out.println(name + " is flying");
    }

    @Override
    public void walk() {
        System.out.println(name + " is walking");
    }
}

class Fish extends Animal implements CanSwim {

    public Fish(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("boolb boolb");
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming");
    }
}

class Dog extends Animal implements CanWalk, CanSwim {

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println("gavgav");
    }

    @Override
    public void walk() {
        System.out.println(name + " is walking");
    }

    @Override
    public void swim() {
        System.out.println(name + " is swimming");
    }
}

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird("Parrot", 2);
        Fish fish = new Fish("Goldfish", 1);
        Dog dog = new Dog("Bulldog", 4);
        
        bird.makeSound();
        bird.fly();
        bird.walk();
        bird.sleep();

        fish.makeSound();
        fish.swim();
        fish.sleep();

        dog.makeSound();
        dog.walk();
        dog.swim();
        dog.sleep();
    }
}
