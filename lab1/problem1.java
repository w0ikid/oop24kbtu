// package lab1;

// import java.util.Scanner;

// class problem1 {
//     private int count;
//     private double sum;
//     private double max = Double.NEGATIVE_INFINITY;

//     public void add(double value) {
//         count++;
//         sum += value;

//         if (value > max) {
//             max = value;
//         }
//     }

//     public double getAverage() {
//         if (count == 0) {
//             return 0.0;
//         }
//         return sum / count;
//     }

    
//     public double getMax() {
//         return (count == 0) ? 0.0 : max;
//     }
// }

// class Analyzer {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         problem1 data = new problem1();

//         while (true) {
//             System.out.print("Enter number (Q to quit): ");
//             String input = scanner.nextLine();

//             if (input.equalsIgnoreCase("Q")) {
//                 System.out.println("Exiting...");
//                 break;
//             }
            
//             // if (input == "q" || input == "Q"){
//             //     System.out.println("Exiting...");
//             //     break;
//             // }
//             try {
//                 double value = Double.parseDouble(input);
//                 data.add(value);
//             } catch (NumberFormatException e) {
//                 System.out.println("Invalid input. Please enter a valid number or 'Q' to quit.");
//             }
//         }

//         scanner.close();
        
//         System.out.printf("Average = %.1f\n", data.getAverage());
//         System.out.printf("Maximum = %.1f\n", data.getMax());
//     }
// }

