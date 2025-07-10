import java.util.Scanner;

public class Day10_CheckArmstrongNumber {

    public static boolean isArmstrong(int num) {
        int original = num, result = 0;
        int digits = String.valueOf(num).length();

        while (num > 0) {
            int digit = num % 10;
            result += Math.pow(digit, digits);
            num /= 10;
        }

        return result == original;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println(isArmstrong(n) ? "✅ Armstrong number" : "❌ Not an Armstrong number");
        sc.close();
    }
}
