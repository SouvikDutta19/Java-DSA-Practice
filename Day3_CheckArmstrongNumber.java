import java.util.Scanner;

public class Day3_CheckArmstrongNumber {

    public static boolean isArmstrong(int number) {
        int original = number, result = 0, digits = 0;

        int temp = number;
        while (temp != 0) {
            digits++;
            temp /= 10;
        }

        temp = number;
        while (temp != 0) {
            int digit = temp % 10;
            result += Math.pow(digit, digits);
            temp /= 10;
        }

        return result == original;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (isArmstrong(num)) {
            System.out.println("✅ " + num + " is an Armstrong number.");
        } else {
            System.out.println("❌ " + num + " is not an Armstrong number.");
        }

        sc.close();
    }
}
