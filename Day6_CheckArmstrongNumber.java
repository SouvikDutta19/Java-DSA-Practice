import java.util.Scanner;

public class Day6_CheckArmstrongNumber {

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
        int number = sc.nextInt();

        if (isArmstrong(number)) {
            System.out.println("✅ " + number + " is an Armstrong Number.");
        } else {
            System.out.println("❌ " + number + " is not an Armstrong Number.");
        }

        sc.close();
    }
}
