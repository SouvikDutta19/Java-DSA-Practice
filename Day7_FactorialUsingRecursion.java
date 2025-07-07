import java.util.Scanner;

public class Day7_FactorialUsingRecursion {

    public static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        long result = factorial(number);
        System.out.println("💡 Factorial of " + number + " is: " + result);

        sc.close();
    }
}
