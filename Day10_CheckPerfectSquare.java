import java.util.Scanner;

public class Day10_CheckPerfectSquare {

    public static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        System.out.println(isPerfectSquare(n) ? "✅ Perfect square" : "❌ Not a perfect square");
        sc.close();
    }
}
