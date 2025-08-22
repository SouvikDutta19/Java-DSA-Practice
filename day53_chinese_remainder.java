public class day53_chinese_remainder {
    public static int chineseRemainder(int[] num, int[] rem, int k) {
        int prod = 1;
        for (int n : num) prod *= n;

        int result = 0;
        for (int i = 0; i < k; i++) {
            int pp = prod / num[i];
            result += rem[i] * mulInv(pp, num[i]) * pp;
        }
        return result % prod;
    }

    private static int mulInv(int a, int b) {
        int b0 = b;
        int x0 = 0, x1 = 1;
        if (b == 1) return 1;
        while (a > 1) {
            int q = a / b;
            int t = b;
            b = a % b;
            a = t;
            t = x0;
            x0 = x1 - q * x0;
            x1 = t;
        }
        if (x1 < 0) x1 += b0;
        return x1;
    }

    public static void main(String[] args) {
        int[] num = {3, 4, 5};
        int[] rem = {2, 3, 1};
        System.out.println("X is " + chineseRemainder(num, rem, 3));
    }
}
