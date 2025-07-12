public class Day12_CheckPrimeInRange {

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    public static void printPrimes(int low, int high) {
        for (int i = low; i <= high; i++) {
            if (isPrime(i))
                System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        int low = 10, high = 50;
        System.out.println("🔢 Prime numbers between " + low + " and " + high + ":");
        printPrimes(low, high);
    }
}
