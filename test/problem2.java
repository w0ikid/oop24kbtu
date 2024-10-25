package test;

public class problem2 {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int newNums = calculator.add(1, 2);

        System.out.println(newNums);
    }
}

class Calculator {
    public int add(int num1, int num2) {
        return num1 + num2;
    }
    public int add(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }
}