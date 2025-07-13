public class Day13_ArmstrongNumbersInRange {

    public static boolean isArmstrong(int n) {
        int original = n, sum = 0, digits = String.valueOf(n).length();
        while (n != 0) {
            int digit = n % 10;
            sum += Math.pow(digit, digits);
            n /= 10;
        }
        return sum == original;
    }

    public static void main(String[] args) {
        System.out.println("🔢 Armstrong numbers from 100 to 999:");
        for (int i = 100; i < 1000; i++) {
            if (isArmstrong(i)) System.out.print(i + " ");
        }
    }
}
