import java.util.Scanner;

public class Day3_CheckPerfectNumber {

    // A number is perfect if it is equal to the sum of its proper divisors
    public static boolean isPerfect(int num) {
        if (num <= 1) return false;

        int sum = 1; // 1 is always a divisor
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check: ");
        int number = scanner.nextInt();

        if (isPerfect(number)) {
            System.out.println("✅ " + number + " is a Perfect Number.");
        } else {
            System.out.println("❌ " + number + " is NOT a Perfect Number.");
        }

        scanner.close();
    }
}
