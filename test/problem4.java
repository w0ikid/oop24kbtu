package test;

public class problem4 {
    public static void main(String[] args) {
        int n = 5;
        
        Animal[] animals = new Animal[n];

        animals[0] = new Animal();
        animals[1] = new Dog();
        animals[2] = new Cat();
        animals[3] = new Dog();
        animals[4] = new Cat();
        

        for (Animal animal : animals) {
            animal.sound();
        }
    }    
}

class Animal {
    public void sound() {
        System.out.println("Some animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meaw");
    }
}