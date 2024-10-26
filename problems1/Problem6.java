// package problems1;

// import java.util.Scanner;

// public class Problem6 {
//     public static void main(String[] args) {
//         Scanner scan=new Scanner(System.in);
//         String palindrome;
//         System.out.println("Palindrome?:");
//         palindrome = scan.nextLine();
//         int length = palindrome.length();
//         scan.close();

//         // palindrome
//         for (int i = 0; i < length / 2; i++) {
//             if (palindrome.charAt(i) != palindrome.charAt(length - i - 1)){
//                 System.out.println("No");
//                 return;
//             }
//         }
//         System.out.println("Yes");
//     }
// }
