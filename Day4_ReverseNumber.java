import java.util.Scanner;

public class Day4_ReverseNumber {

    public static int reverse(int num) {
        int reversed = 0;
        while (num != 0) {
            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int result = reverse(number);
        System.out.println("🔁 Reversed: " + result);

        sc.close();
    }
}
