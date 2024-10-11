package problems3.first;

class Animal {
    private String name;
    private int legCount;
    private String sound;

    {
        name = "McDonnell Douglas AH-64 Apache";
        legCount = 0;
        sound = "Democracy!";
    }

    public Animal(){
        //
    }

    public Animal(String name, int legCount, String sound){
        this.name = name;
        this.legCount = legCount;
        this.sound = sound;
    }

    public String getName(){
        return name;
    }

    public int getLegCount(){
        return legCount;
    }

    public String getSound(){
        return sound;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLegCount(int legCount){
        this.legCount = legCount;
    }

    public void setSound(String sound){
        this.sound = sound;
    }

    // overridden
    public void makeSound(){
        System.out.println("Some sound ~~~ " + sound + "\n");
    }

    // overloading
    public void makeSound(String place){
        System.out.println("Animal sound in " + place + "|-|" + sound + "\n");
    }

}

class Dog extends Animal {
    public Dog() {
        super("Unknown Dog", 4, "Woof");
    }

    public Dog(String name, int legCount, String sound){
        super(name, legCount, sound);
    }

    @Override
    public void makeSound() {
        System.out.println("Gav! Gav!");
    }

    @Override
    public void makeSound(String place) {
        System.out.println("In " + place + ": Gaaav!!!\n");
    }
}


class Cat extends Animal {
    public Cat() {
        super("Unknown Cat", 4, "Meo!");
    }

    public Cat(String name, int legCount, String sound) {
        super(name, legCount, sound);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public void makeSound(String place) {
        System.out.println("In " + place + ": MEOOOOW!!!\n");
    }
}

class Main {
    public static void main(String[] args) {
        Dog newDog1 = new Dog();
        Dog newDog2 = new Dog("Sobaka", 4, "Rrrr");
        System.out.println(newDog1.getSound());
        newDog1.makeSound();
        System.out.println(newDog2.getSound());
        newDog2.makeSound();

        Animal newAnimal = new Animal("Parrot", 2, "Cookies");
        System.out.println(newAnimal.getSound());
        newAnimal.makeSound();
    }
}