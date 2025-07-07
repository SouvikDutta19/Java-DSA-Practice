import java.util.Scanner;

public class Day7_ReverseNumberRecursion {

    public static int reverse(int num, int rev) {
        if (num == 0) return rev;
        return reverse(num / 10, rev * 10 + num % 10);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int result = reverse(number, 0);
        System.out.println("🔁 Reversed: " + result);

        sc.close();
    }
}
