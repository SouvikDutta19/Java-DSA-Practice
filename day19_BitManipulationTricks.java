public class BitManipulationTricks {
    public static boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }

    public static int countSetBits(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static int getRightmostSetBitPos(int n) {
        return (int)(Math.log(n & -n) / Math.log(2)) + 1;
    }

    public static void main(String[] args) {
        System.out.println("Is 16 power of 2: " + isPowerOfTwo(16));
        System.out.println("Set bits in 29: " + countSetBits(29));
        System.out.println("Rightmost set bit position in 18: " + getRightmostSetBitPos(18));
    }
}
