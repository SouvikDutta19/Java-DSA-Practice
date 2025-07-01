import java.util.Scanner;

/**
 * Day 4: Fibonacci Series Generator (Iterative Approach)
 * Author: Souvik Dutta
 *
 * Description:
 * This program prints the first N numbers in the Fibonacci series.
 * It uses an efficient iterative approach with O(N) time and O(1) space.
 */

public class Day1_FibonacciSeries {

    /**
     * Prints the first n Fibonacci numbers.
     *
     * @param n the count of Fibonacci numbers to print
     */
    public static void printFibonacci(int n) {
        if (n <= 0) {
            System.out.println("❗ Please enter a positive integer.");
            return;
        }

        long a = 0, b = 1;

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            long next = a + b;
            a = b;
            b = next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("🔢 Enter how many Fibonacci numbers to generate: ");
        int n = scanner.nextInt();

        System.out.println("📈 Fibonacci Series:");
        printFibonacci(n);

        scanner.close();
    }
}
