package one;

interface Payable {
    void payRetakeFee();
}

interface Testable {
    void takeExtraTest();
}

abstract class Student {
    protected String name;
    protected String studentId;

    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public void registerForRetake() {
        System.out.println(name + " (" + studentId + ") has registered for the retake.");
    }

    public abstract void takeRetake();
}

class BachelorStudent extends Student implements Payable {
    public BachelorStudent(String name, String studentId) {
        super(name, studentId);
    }

    @Override
    public void takeRetake() {
        System.out.println(name + " is take retake for undergraduate course");
    }

    @Override
    public void payRetakeFee() {
        System.out.println(name + " has paid the retake fee");
    }
}

class MasterStudent extends Student implements Payable, Testable {
    public MasterStudent(String name, String studentId) {
        super(name, studentId);
    }

    @Override
    public void takeRetake() {
        System.out.println(name + " is take retake for graduate course");
    }

    @Override
    public void payRetakeFee() {
        System.out.println(name + " has paid the retake fee");
    }

    @Override
    public void takeExtraTest() {
        System.out.println(name + " is taking an extra test as part of the retake process");
    }
}

class PhDStudent extends Student {
    public PhDStudent(String name, String studentId) {
        super(name, studentId);
    }

    @Override
    public void takeRetake() {
        System.out.println(name + " is retaking the dissertation defense");
    }
}

public class KBTURetakeExample {
    public static void main(String[] args) {
        Student bachelor = new BachelorStudent("Aigerim", "KBTU123");
        Student master = new MasterStudent("Dias", "KBTU456");
        Student phd = new PhDStudent("Madina", "KBTU789");
        
        bachelor.registerForRetake();
        bachelor.takeRetake();
        ((Payable) bachelor).payRetakeFee();

        System.out.println();
        
        master.registerForRetake();
        master.takeRetake();
        ((Payable) master).payRetakeFee();
        ((Testable) master).takeExtraTest();

        System.out.println();

        phd.registerForRetake();
        phd.takeRetake();
    }
}
