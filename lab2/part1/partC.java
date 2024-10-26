package lab2.part1;

import java.util.HashSet;
import java.util.Objects;

public class partC {
    public static void main(String[] args) {
        HashSet<Animal> animalSet = new HashSet<>();

        Animal dog1 = new Dog("akita", 5, "123ABC");
        Animal dog2 = new Dog("akita", 5, "123ABC");
        Animal dog3 = new Dog("germen shepherd dog", 3, "456DEF");
        Animal cat1 = new Cat("someothercat", 1, "123OOO");
        Animal cat2 = new Cat("somecat", 1, "123OOO");

        animalSet.add(dog1);
        animalSet.add(dog2);
        animalSet.add(dog3);
        animalSet.add(cat1);
        animalSet.add(cat2);

        for (Animal a : animalSet) {
            System.out.println(a);
        }



        System.out.println("unique in HashSet: " + animalSet.size());
    }
}

class Animal {
    private String type;
    private int age;

    public Animal(String type, int age) {
        this.type = type;
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public int getAge() {
        return age;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Animal animal = (Animal) obj;
        return age == animal.age && Objects.equals(this.type, animal.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, age);
    }

    @Override
    public String toString() {
        return "Animal type= " + type + " age=" + age;
    }
}
    
class Dog extends Animal {
    private String chipId;

    public Dog(String type, int age, String chipId) {
        super(type, age);
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Dog dog = (Dog) obj;
        return Objects.equals(chipId, dog.chipId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), chipId);
    }

    @Override
    public String toString() {
        return "Dog type= " + getType() + " age=" + getAge() + " chipId=" + chipId;
    }
}

class Cat extends Animal {
    private String chipId;

    public Cat(String type, int age, String chipId) {
        super(type, age);
        this.chipId = chipId;
    }

    @Override
    public int getAge() {
        // TODO Auto-generated method stub
        return super.getAge();
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()){
            return false;
        }
        Cat cat = (Cat) obj;
        return Objects.equals(chipId, cat.chipId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), chipId);
    }

    @Override
    public String toString() {
        return "Cat type= " + getType() + " age=" + getAge() + " chipId=" + chipId;
    }
}