public class day37_nth_root_of_number_binary_search {

    public static double nthRoot(int n, int m) {
        double low = 1, high = m, eps = 1e-6;

        while ((high - low) > eps) {
            double mid = (low + high) / 2.0;
            if (Math.pow(mid, n) < m) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int n = 3, m = 27;
        System.out.printf("The %.2f is the %d-th root of %d%n", nthRoot(n, m), n, m);
    }
}
