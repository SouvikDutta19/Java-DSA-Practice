import java.util.Scanner;

public class Day7_PrintPrimeInRange {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void printPrimes(int start, int end) {
        System.out.print("🔢 Prime numbers: ");
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter start and end range: ");
        int start = sc.nextInt();
        int end = sc.nextInt();

        printPrimes(start, end);
        sc.close();
    }
}
