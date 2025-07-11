import java.util.Scanner;

public class Day11_GCDUsingRecursion {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int a = sc.nextInt(), b = sc.nextInt();

        System.out.println("🧮 GCD: " + gcd(a, b));
        sc.close();
    }
}
