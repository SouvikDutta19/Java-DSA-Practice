import java.util.Scanner;

public class Day7_CheckPerfectNumber {

    public static boolean isPerfect(int num) {
        int sum = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) sum += i;
        }
        return num != 1 && sum == num;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        if (isPerfect(number)) {
            System.out.println("✅ " + number + " is a Perfect Number.");
        } else {
            System.out.println("❌ " + number + " is not a Perfect Number.");
        }

        sc.close();
    }
}
