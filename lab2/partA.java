package lab2;

/**
 * partA
 */
public class partA {
    public static void main(String[] args) {
        Shape3D[] shapes = new Shape3D[3];

        shapes[0] = new Cylinder(13, 17);
        shapes[1] = new Cube(15);
        shapes[2] = new Sphere(7);

        for (Shape3D shape3d : shapes) {
            System.out.println(shape3d.volume() + " " + shape3d.surfaceArea());
        }
    }
}

abstract class Shape3D {
    abstract double volume();

    abstract double surfaceArea();
}

class Cylinder extends Shape3D{
    private double radius, height;

    public Cylinder(double radius, double height){
        this.height = height;
        this.radius = radius;
    }

    @Override
    public double volume(){
        return Math.PI * radius * radius * height;
    }
    
    @Override
    public double surfaceArea(){
        return 2 * Math.PI * radius * (radius + height);
    }


}

class Sphere extends Shape3D {
    private double radius;

    public Sphere(double radius){
        this.radius = radius;
    }

    @Override
    public double volume(){
        return 4 / 3 * Math.PI * radius * radius * radius;
    }

    @Override
    public double surfaceArea(){
        return 4 * Math.PI * radius * radius;
    }
}

class Cube extends Shape3D {
    private double height;

    public Cube(double height){
        this.height = height;
    }

    @Override
    public double volume(){
        return height * height * height;
    }

    @Override
    public double surfaceArea(){
        return 6 * height * height;
    }
}