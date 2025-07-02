import java.util.Scanner;

public class Day2_FactorialUsingRecursion {

    // Recursive function to calculate factorial
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer to calculate its factorial: ");
        int number = scanner.nextInt();

        try {
            long result = factorial(number);
            System.out.println("✅ Factorial of " + number + " is: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        scanner.close();
    }
}
