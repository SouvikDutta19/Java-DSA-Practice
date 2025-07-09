import java.util.Scanner;

public class Day9_SumOfEvenOddDigits {

    public static void calculateSums(int num) {
        int evenSum = 0, oddSum = 0;

        while (num != 0) {
            int digit = num % 10;
            if (digit % 2 == 0)
                evenSum += digit;
            else
                oddSum += digit;
            num /= 10;
        }

        System.out.println("➕ Sum of even digits: " + evenSum);
        System.out.println("➖ Sum of odd digits: " + oddSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        calculateSums(number);
        sc.close();
    }
}
