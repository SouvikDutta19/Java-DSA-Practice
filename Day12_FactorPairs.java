import java.util.Scanner;

public class Day12_FactorPairs {

    public static void printFactorPairs(int n) {
        System.out.println("🧮 Factor Pairs of " + n + ":");
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.println(i + " x " + (n / i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        printFactorPairs(num);
        sc.close();
    }
}
