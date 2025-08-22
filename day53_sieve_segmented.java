import java.util.*;

public class day53_sieve_segmented {
    public static void simpleSieve(int limit, List<Integer> primes) {
        boolean[] mark = new boolean[limit + 1];
        Arrays.fill(mark, true);
        for (int p = 2; p * p <= limit; p++) {
            if (mark[p]) {
                for (int i = p * p; i <= limit; i += p) mark[i] = false;
            }
        }
        for (int p = 2; p <= limit; p++) if (mark[p]) primes.add(p);
    }

    public static void segmentedSieve(int n) {
        int limit = (int) Math.floor(Math.sqrt(n)) + 1;
        List<Integer> primes = new ArrayList<>();
        simpleSieve(limit, primes);

        int low = limit;
        int high = 2 * limit;

        while (low < n) {
            if (high >= n) high = n;
            boolean[] mark = new boolean[high - low + 1];
            Arrays.fill(mark, true);

            for (int prime : primes) {
                int loLim = (low / prime) * prime;
                if (loLim < low) loLim += prime;
                for (int j = loLim; j < high; j += prime) mark[j - low] = false;
            }

            for (int i = low; i < high; i++) if (mark[i - low]) System.out.print(i + " ");
            low = low + limit;
            high = high + limit;
        }
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println("Primes up to " + n + ":");
        segmentedSieve(n);
    }
}
