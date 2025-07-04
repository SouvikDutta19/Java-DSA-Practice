import java.util.Scanner;

public class Day4_GCDofTwoNumbers {

    public static int gcd(int a, int b) {
        while (b != 0) {
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        int result = gcd(x, y);
        System.out.println("🧮 GCD: " + result);

        sc.close();
    }
}
