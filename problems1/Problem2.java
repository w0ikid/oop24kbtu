package problems1;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n;
        n = scan.nextInt();
        scan.close();
        System.out.println("Area: "+(n*n));
        System.out.println("Perimeter: "+(n*4));
        System.out.println("Length of diagonal: "+Math.sqrt(n*n + n*n));
        // System.out.printf("Diagonal: %.2f\n", Math.sqrt(n*n + n*n));
    }
}