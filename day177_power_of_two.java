public class day177_power_of_two {

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        int n = 16;
        System.out.println("Is Power of Two: " + isPowerOfTwo(n));
    }
}