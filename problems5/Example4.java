// import java.util.*;

// public class Example4 {
//     public static void main(String[] args) {
//         Scanner in = new Scanner(System.in);
//         System.out.println("Example (1+2, 1*2, 10/5, 10*2)");

//         while (in.hasNextLine()){
//             String input = in.nextLine().trim();
//             if (input.isEmpty()) {
//                 break;
//             }

//             StringTokenizer tokenizer = new StringTokenizer(input, "+-/*", true);

//             try {
//                 String leftString = tokenizer.nextToken();
//                 String operator = tokenizer.nextToken();
//                 String rightString = tokenizer.nextToken();

//                 double leftOperand, rightOperand, result = 0;

//                 try {
//                     leftOperand = Double.parseDouble(leftString);
//                 } catch (NumberFormatException e) {
//                     System.out.println(leftString + " не является числом");
//                     continue;
//                 }

//                 try {
//                     rightOperand = Double.parseDouble(rightString);
//                 } catch (NumberFormatException e) {
//                     System.out.println(rightString + " не является числом");
//                     continue;
//                 }

//                 if (operator.equals("+")){
//                     result = leftOperand + rightOperand;
//                 } else if (operator.equals("-")){
//                     result = leftOperand - rightOperand;
//                 } else if (operator.equals("*")){
//                     result = leftOperand * rightOperand;
//                 } else if (operator.equals("/")){
//                     if (rightOperand == 0){
//                         System.out.println("divisio by zero is undefined");
//                         continue;
//                     }
//                     result = leftOperand / rightOperand;
//                 } else {
//                     System.out.println("Unknown operator: " + operator);
//                 }

//                 System.out.println("result: " + result);
                
//             } catch (NoSuchElementException e) {
//                 System.out.println("Invalid syntax");
//             }

//             System.out.println("done");
//         }
//     }
// }