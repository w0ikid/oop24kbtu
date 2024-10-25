package test;

/**
 * problem8
 */
public class problem8 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[4];

        employees[0] = new Employee();
        employees[1] = new Manager();
        employees[2] = new Employee();
        employees[3] = new Developer();
        
        for (Employee employee : employees) {
            employee.work();
        }

    }
}

class Employee {
    public void work(){
        System.out.println("Сотрудник работает.");
    }
}


class Manager extends Employee {
    @Override
    public void work(){
        System.out.println("Менеджер работает");
    }
}

class Developer extends Employee {
    @Override
    public void work(){
        System.out.println("Разработчик работает");
    }
}
