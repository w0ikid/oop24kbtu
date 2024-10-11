package problems3.second;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAddress(String newAddress) {
        this.address = newAddress;
    }

    @Override
    public String toString() {
        return String.format("Person[name=%s, address=%s]", name, address);
    }
}

class Student extends Person {
    private String program;
    private int year;
    private double fee;

    public Student(String name, String address, String program, int year, double fee) {
        super(name, address);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return String.format("Student[Person[name=%s, address=%s], program=%s, year=%d, fee=%.2f]", 
                             getName(), getAddress(), program, year, fee);
    }
}

class Staff extends Person {
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return String.format("Staff[Person[name=%s, address=%s], school=%s, pay=%.2f]", 
                             getName(), getAddress(), school, pay);
    }
}

public class problems2 {
    public static void main(String[] args) {
        Set<Person> people = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("1. Add a person");
            System.out.println("2. Print all persons");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 1) {
                System.out.println("Enter type (1-Student, 2-Staff):");
                int type = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                
                System.out.println("Enter name:");
                String name = scanner.nextLine();
                System.out.println("Enter address:");
                String address = scanner.nextLine();

                if (type == 1) {
                    System.out.println("Enter program:");
                    String program = scanner.nextLine();
                    System.out.println("Enter year:");
                    int year = scanner.nextInt();
                    System.out.println("Enter fee:");
                    double fee = scanner.nextDouble();
                    people.add(new Student(name, address, program, year, fee));
                } else if (type == 2) {
                    System.out.println("Enter school:");
                    String school = scanner.nextLine();
                    System.out.println("Enter pay:");
                    double pay = scanner.nextDouble();
                    people.add(new Staff(name, address, school, pay));
                }
            } else if (choice == 2) {
                for (Person person : people) {
                    System.out.println(person);
                }
            } else if (choice == 3) {
                break;
            }
        }
        scanner.close();
    }
    
}
