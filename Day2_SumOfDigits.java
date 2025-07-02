import java.util.Scanner;

public class Day2_SumOfDigits {

    // Calculates sum of digits of a non-negative number
    public static int sumOfDigits(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Only non-negative integers are allowed.");
        }

        int sum = 0;
        while (number > 0) {
            sum += number % 10;  // Add the last digit
            number /= 10;        // Remove the last digit
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer: ");
        int input = scanner.nextInt();

        try {
            int result = sumOfDigits(input);
            System.out.println("🔢 Sum of digits: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        scanner.close();
    }
}
