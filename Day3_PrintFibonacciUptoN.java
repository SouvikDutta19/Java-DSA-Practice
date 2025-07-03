import java.util.Scanner;

public class Day3_PrintFibonacciUptoN {

    public static void printFibonacci(int limit) {
        int a = 0, b = 1;
        System.out.print("🔢 Fibonacci Series up to " + limit + ": ");
        while (a <= limit) {
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter upper limit: ");
        int n = sc.nextInt();
        printFibonacci(n);
        sc.close();
    }
}
