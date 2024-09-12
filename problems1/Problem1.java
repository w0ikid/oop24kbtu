package problems1;

import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String name;
        name = scan.next();
        int len = name.length();

        System.out.print("+");
        for (int i = 0; i < len; i++) {
            System.out.print("-");;
        }
        System.out.print("+\n");
        System.out.printf("|%s|\n", name);
        System.out.print("+");
        for (int i = 0; i < len; i++) {
            System.out.print("-");;
        }
        System.out.print("+\n");
    }
}