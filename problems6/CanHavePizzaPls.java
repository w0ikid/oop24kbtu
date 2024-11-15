import java.util.Random;
import java.util.Stack;

interface CanHavePizza {
    void eatPizza();

    default void Undo(Restaurant restaurant) {
        restaurant.Undo(this);
    }
}

class Restaurant {
    static int pizzaSlices = 0;

    static Stack<Integer> history = new Stack<>();

    public void Undo(CanHavePizza actor){
        if (!history.isEmpty()){
            pizzaSlices = history.pop();
            System.out.println(actor + " undid the last section! Pizza slices: " + pizzaSlices);
        } else {
            System.out.println("some error with undo");
        }
    }

    public int getCountpizzaSlices(){
        return pizzaSlices;
    }
}

class Cat implements CanHavePizza {
    @Override
    public void eatPizza(){
        if (Restaurant.pizzaSlices > 0) {
            Restaurant.pizzaSlices--;
            System.out.println("cat is eating pizza");
        } else {
            System.out.println("no pizza :<");
        }
    }

    public void stealPizza(){
        Random random = new Random();
        boolean randomBoolean = random.nextBoolean();
        if (randomBoolean && Restaurant.pizzaSlices > 0) {
            Restaurant.pizzaSlices--;
            System.out.println("pizza stolen hehe");
        } else if (Restaurant.pizzaSlices == 0) {
            System.out.println("no pizza to steal :<");
        } else {
            System.out.println("failed to steal the pizza :< not hehe");
        }
        
    }

    @Override
    public String toString() {
        return "Cat";
    }
}

class Person implements CanHavePizza {
    @Override
    public void eatPizza() {
        if (Restaurant.pizzaSlices > 0) {
            Restaurant.history.push(Restaurant.pizzaSlices);
            Restaurant.pizzaSlices--;
            System.out.println("person is eating pizza");
        } else {
            System.out.println("no pizza :<");
        }
    }


    public void slicePizza(int n) {
        if (n > 0) {
            Restaurant.history.push(Restaurant.pizzaSlices);
            Restaurant.pizzaSlices = n;
            System.out.println("pizza slices: " + n);
        } else {
            System.out.println("error to set slicePizza");
        }
    }

    @Override
    public String toString() {
        return "Person";
    }
}

public class CanHavePizzaPls {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Person person = new Person();
        Cat cat = new Cat();
    
        // устанавливаем кусочки
        person.slicePizza(10);
        System.out.println("pizza slices: " + restaurant.getCountpizzaSlices());
        // еда
        person.eatPizza();
        System.out.println("pizza slices: " + restaurant.getCountpizzaSlices());
        cat.eatPizza();
        System.out.println("pizza slices: " + restaurant.getCountpizzaSlices());
    
        // кража
        cat.stealPizza();
        System.out.println("pizza slices: " + restaurant.getCountpizzaSlices());
    
        // отмена
        person.Undo(restaurant);
        System.out.println("pizza slices: " + restaurant.getCountpizzaSlices());
        cat.Undo(restaurant);
        System.out.println("pizza slices: " + restaurant.getCountpizzaSlices());
    }
    
}