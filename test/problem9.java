package test;

/**
 * problem9
 */
public class problem9 {
    public static void main(String[] args) {
        
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return String.format("Name: %s, Age: %d", name, age);
    }
}

class Student extends Person {
    private String retake;

    public Student(String name, int age, String retake){
        super(name, age);
        this.retake = retake;
    }
    /*
     * some changes
     * 
     * some changes
     */

    public String getRetake(){
        return retake;
    }

    @Override
    public String toString(){
        return String.format("%s Retake: %s", super.toString(), retake);
    }
}