package six;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

interface CanFeed {
    void feed(Animal pet);
}

interface CanTrain {
    void train(Animal pet);
}

abstract class Person implements Comparable<Person>, Serializable, CanFeed {
    protected String name;
    protected int age;
    protected Animal pet;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void assignPet(Animal pet) {
        if (this instanceof PhDStudent && pet instanceof Dog) {
            System.out.println("PhD students cannot have high-maintenance pets like dogs.");
        } else {
            this.pet = pet;
        }
    }

    public void removePet() {
        this.pet = null;
    }

    public boolean hasPet() {
        return this.pet != null;
    }

    public Animal getPet() {
        return this.pet;
    }

    public abstract String getOccupation();

    public void leavePetWith(Person caretaker) {
        if (this.pet == null) {
            System.out.println(this.name + " has no pet to leave.");
            return;
        }
        if (caretaker instanceof PhDStudent && pet instanceof Dog) {
            System.out.println("PhD students cannot take care of high-maintenance pets like dogs.");
            return;
        }
        caretaker.assignPet(this.pet);
        this.removePet();
    }

    public void retrievePetFrom(Person caretaker) {
        if (caretaker.getPet() == null) {
            System.out.println(caretaker.name + " has no pet to return.");
            return;
        }
        if (this.pet == null) {
            this.assignPet(caretaker.getPet());
            caretaker.removePet();
        } else {
            System.out.println(this.name + " already has a pet.");
        }
    }

    @Override
    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public void feed(Animal pet) {
        System.out.println(this.name + " feeds " + pet.name);
    }

    @Override
    public String toString() {
        return name + " " + getOccupation() + " Age: " + age + ", Pet: " + (hasPet() ? pet : "No pet");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class Employee extends Person implements CanTrain {
    private String jobTitle;

    public Employee(String name, int age, String jobTitle) {
        super(name, age);
        this.jobTitle = jobTitle;
    }

    @Override
    public String getOccupation() {
        return "Employee - " + jobTitle;
    }

    @Override
    public void train(Animal pet) {
        System.out.println(this.name + " is training " + pet.name);
    }
}

class Student extends Person {
    private String major;

    public Student(String name, int age, String major) {
        super(name, age);
        this.major = major;
    }

    @Override
    public String getOccupation() {
        return "Student - " + major;
    }
}

class PhDStudent extends Person {
    private String researchArea;

    public PhDStudent(String name, int age, String major, String researchArea) {
        super(name, age);
        this.researchArea = researchArea;
    }

    @Override
    public String getOccupation() {
        return "PhD Student - " + researchArea;
    }
}

abstract class Animal implements Serializable {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract String getSound();

    public void performTrick() {
        System.out.println(this.name + " performs a trick!");
    }

    @Override
    public String toString() {
        return name + " " + getClass().getSimpleName() + " Age: " + age + " Sound: " + getSound();
    }
}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String getSound() {
        return "Meow";
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String getSound() {
        return "Woof";
    }
}

class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public String getSound() {
        return "Tweet";
    }
}

class Fish extends Animal {
    public Fish(String name, int age) {
        super(name, age);
    }

    @Override
    public String getSound() {
        return "Blub";
    }
}

class PersonRegistry {
    private ArrayList<Person> people;

    public PersonRegistry() {
        people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
        System.out.println("Added " + person.name + " to registry.");
    }

    public void removePerson(Person person) {
        people.remove(person);
        System.out.println("Removed " + person.name + " from registry.");
    }

    public ArrayList<Person> getPeopleWithPets() {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (person.hasPet()) {
                result.add(person);
            }
        }
        return result;
    }

    public ArrayList<Person> getPeopleWithoutPets() {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (!person.hasPet()) {
                result.add(person);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Person Registry:\n");
        for (Person person : people) {
            sb.append(person).append("\n");
        }
        return sb.toString();
    }
}

// Main Test Class
public class PetManagementSystemTest {
    public static void main(String[] args) {
        Person danial = new Employee("Danial", 19, "jobless");
        Person nurik = new PhDStudent("Nurik", 18, "Comp. Science", "AI");
        Person boshka = new Employee("Boshka", 25, "CEO of Nvidia");

        Animal murka = new Cat("Murka", 5);
        Animal rex = new Dog("Rex", 3);

        // Назначение питомцев
        danial.assignPet(rex);
        nurik.assignPet(murka);

        // Кормление питомцев
        danial.feed(rex);
        nurik.feed(murka);

        // Тренировка питомцев
        ((Employee) danial).train(rex);
        ((Employee) boshka).train(murka);

        // Сравнение людей
        System.out.println("Comparing ages: " + danial.compareTo(nurik));

        // Регистрация людей
        PersonRegistry registry = new PersonRegistry();
        registry.addPerson(danial);
        registry.addPerson(nurik);
        registry.addPerson(boshka);

        System.out.println("\nRegistry:\n" + registry);

        // Передача питомцев
        nurik.leavePetWith(boshka);
        System.out.println("\nAfter transferring pet:\n" + registry);

        // Трюки животных
        murka.performTrick();
        rex.performTrick();
    }
}
