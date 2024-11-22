package two;

// addition
interface Moveable {
    void move();
}

interface AdvancedMoveable extends Moveable {
    void moveFast();
    void moveWithTools();
}


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

class BachelorStudent extends Student implements Payable, Moveable {
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

    @Override
    public void move(){
        System.out.println(name + " walks");
    }
}

class MasterStudent extends Student implements Payable, Testable, AdvancedMoveable {
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
    @Override
    public void move(){
        System.out.println(name + "walks");
    }
    @Override
    public void moveFast(){
        System.out.println(name + "move fast");
    }
    @Override
    public void moveWithTools(){
        System.out.println(name + "move with electric scooter");
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

public class KBTUretakeButStudentsMove {    
    public static void main(String[] args) {
        Student bachelor = new BachelorStudent("Aigerim", "KBTU123");
        Student master = new MasterStudent("Dias", "KBTU456");
        Student phd = new PhDStudent("Madina", "KBTU789");
        

        ((Moveable) bachelor).move();

        ((AdvancedMoveable) master).moveWithTools();







        // bachelor.registerForRetake();
        // bachelor.takeRetake();
        // ((Payable) bachelor).payRetakeFee();

        // System.out.println();
        
        // master.registerForRetake();
        // master.takeRetake();
        // ((Payable) master).payRetakeFee();
        // ((Testable) master).takeExtraTest();

        // System.out.println();

        // phd.registerForRetake();
        // phd.takeRetake();
}
}
