package part4;

import java.util.*;
import java.util.stream.Collectors;

class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person person = (Person) obj;
        return Objects.equals(name, person.name);
    }
}

class Employee extends Person implements Comparable<Employee>, Cloneable {
    private double salary;
    private Date hireDate;
    private String nationalInsuranceNumber;

    public Employee(String name, double salary, Date hireDate, String nationalInsuranceNumber) {
        super(name);
        this.salary = salary;
        this.hireDate = hireDate;
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getNationalInsuranceNumber() {
        return nationalInsuranceNumber;
    }

    public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
        this.nationalInsuranceNumber = nationalInsuranceNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                ", nationalInsuranceNumber='" + nationalInsuranceNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee employee = (Employee) obj;
        return Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(hireDate, employee.hireDate) &&
                Objects.equals(nationalInsuranceNumber, employee.nationalInsuranceNumber) &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.salary, other.salary);
    }

    @Override
    public Employee clone() {
        try {
            Employee clone = (Employee) super.clone();
            clone.hireDate = (Date) hireDate.clone(); // Глубокое клонирование даты
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Manager extends Employee {
    private Vector<Employee> team;
    private double bonus;

    public Manager(String name, double salary, Date hireDate, String nationalInsuranceNumber, double bonus) {
        super(name, salary, hireDate, nationalInsuranceNumber);
        this.team = new Vector<>();
        this.bonus = bonus;
    }

    public Vector<Employee> getTeam() {
        return team;
    }

    public void addTeamMember(Employee employee) {
        team.add(employee);
    }

    public void removeTeamMember(Employee employee) {
        team.remove(employee);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name='" + getName() + '\'' +
                ", salary=" + getSalary() +
                ", hireDate=" + getHireDate() +
                ", nationalInsuranceNumber='" + getNationalInsuranceNumber() + '\'' +
                ", bonus=" + bonus +
                ", team=" + team.stream().map(Employee::getName).collect(Collectors.joining(", ")) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Manager)) return false;
        if (!super.equals(obj)) return false;
        Manager manager = (Manager) obj;
        return Double.compare(manager.bonus, bonus) == 0 &&
                Objects.equals(team, manager.team);
    }

    @Override
    public Manager clone() {
        Manager clone = (Manager) super.clone();
        clone.team = (Vector<Employee>) team.clone(); // Глубокое клонирование команды
        return clone;
    }
}

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

class HireDateComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getHireDate().compareTo(e2.getHireDate());
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Kural", 50000, new Date(2020 - 1900, 1, 1), "NI123");
        Employee e2 = new Employee("Bob", 60000, new Date(2019 - 1900, 5, 10), "NI124");

        Manager m1 = new Manager("Carol", 80000, new Date(2018 - 1900, 3, 15), "NI125", 10000);
        m1.addTeamMember(e1);
        m1.addTeamMember(e2);

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(m1);

        System.out.println("e1 equals e2: " + e1.equals(e2));
        System.out.println("m1 equals clone: " + m1.equals(m1.clone()));

        // Сравнение
        System.out.println("Comparison by salary: " + e1.compareTo(e2));
        System.out.println("Comparison by name: " + new NameComparator().compare(e1, e2));
        System.out.println("Comparison by hire date: " + new HireDateComparator().compare(e1, e2));

        // Проверка клонирования
        Manager m2 = m1.clone();
        System.out.println("Cloned manager: " + m2);
    }
}
