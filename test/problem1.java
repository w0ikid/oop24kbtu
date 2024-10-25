package test;

public class problem1 {
    public static void main(String[] args) {
        
    }
}

class Circle {
    private double radius;

    public double getArea(){
        return Math.PI * radius*radius;
    }

    public double getCircumference(){
        return 2 * Math.PI * radius;
    }

    public Circle(int radius){
        this.radius = radius; 
    }

    public double getRadius(){
        return radius;
    }

    public void setRadius(int NewRadius){
        this.radius = NewRadius;
    }
}