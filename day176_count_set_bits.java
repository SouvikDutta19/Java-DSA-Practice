public class day176_count_set_bits {

    public static int countBits(int n) {
        int count = 0;
        while (n > 0) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countBits(13));
    }
}