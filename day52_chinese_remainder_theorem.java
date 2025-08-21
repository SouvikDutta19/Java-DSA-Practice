public class day52_chinese_remainder_theorem {

    public static int gcdExtended(int a, int b, int[] x, int[] y) {
        if (a == 0) {
            x[0] = 0; y[0] = 1;
            return b;
        }
        int[] x1 = new int[1], y1 = new int[1];
        int gcd = gcdExtended(b % a, a, x1, y1);
        x[0] = y1[0] - (b / a) * x1[0];
        y[0] = x1[0];
        return gcd;
    }

    public static int modInverse(int a, int m) {
        int[] x = new int[1], y = new int[1];
        int g = gcdExtended(a, m, x, y);
        if (g != 1) throw new IllegalArgumentException("No modular inverse");
        return (x[0] % m + m) % m;
    }

    public static int chineseRemainder(int[] num, int[] rem, int k) {
        int prod = 1;
        for (int i = 0; i < k; i++) prod *= num[i];

        int result = 0;
        for (int i = 0; i < k; i++) {
            int pp = prod / num[i];
            result += rem[i] * modInverse(pp, num[i]) * pp;
        }
        return result % prod;
    }

    public static void main(String[] args) {
        int[] num = {3, 4, 5};
        int[] rem = {2, 3, 1};
        int k = num.length;
        System.out.println("x is " + chineseRemainder(num, rem, k));
    }
}
