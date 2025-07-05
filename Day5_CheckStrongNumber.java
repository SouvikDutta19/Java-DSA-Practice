import java.util.Scanner;

public class Day5_CheckStrongNumber {

    public static int factorial(int num) {
        int fact = 1;
        for (int i = 2; i <= num; i++) fact *= i;
        return fact;
    }

    public static boolean isStrong(int number) {
        int sum = 0, temp = number;
        while (temp != 0) {
            int digit = temp % 10;
            sum += factorial(digit);
            temp /= 10;
        }
        return sum == number;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        if (isStrong(n)) {
            System.out.println("💪 " + n + " is a Strong Number.");
        } else {
            System.out.println("❌ " + n + " is not a Strong Number.");
        }

        sc.close();
    }
}
