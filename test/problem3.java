package test;

public class problem3 {
    public static void main(String[] args) {
        Car car = new Car();
        Vehicle vehicle = new Vehicle();
        car.move();
        vehicle.move(); 
    }    
}

class Vehicle {
    public void move(){
        System.out.println("Это транспортное средство движется");
    }
}

class Car extends Vehicle {
    @Override
    public void move(){
        System.out.println("Машина едет");
    }
}

