// package problems1;

// import java.util.Scanner;

// public class Problem4 {
//     public static void main(String[] args) {
//         // Create a Scanner object to get input from the user
//         Scanner scan = new Scanner(System.in);
        
//         // Get values of a, b, and c from the user
//         System.out.print("a: ");
//         double a = scan.nextDouble();
//         System.out.print("b: ");
//         double b = scan.nextDouble();
//         System.out.print("c: ");
//         double c = scan.nextDouble();
//         scan.close();
//         //(D = b^2 - 4ac)
//         // (x+2)(x-2) = x^2-2^2
//         double discriminant = b * b - 4 * a * c;

//         if (discriminant < 0) {
//             System.out.println("Error: The equation has complex roots since the discriminant is negative.");
//         } else {
//             double sqrtDiscriminant = Math.sqrt(discriminant);
            
//             double root1 = (-b + sqrtDiscriminant) / (2 * a);
//             double root2 = (-b - sqrtDiscriminant) / (2 * a);
            
//             if (discriminant == 0) {
//                 System.out.println("The equation has one real root: " + root1);
//             } else {
//                 System.out.println("The equation has two real roots: " + root1 + " and " + root2);
//             }
//         }
//     }
// }
