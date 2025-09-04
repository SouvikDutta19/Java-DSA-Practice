import java.io.*;
import java.util.*;

public class day66_suffix_array {
    static int[] buildSuffixArray(String s) {
        int n = s.length();
        int[] sa = new int[n], rank = new int[n], tmp = new int[n];
        for (int i = 0; i < n; i++) { sa[i] = i; rank[i] = s.charAt(i); }

        for (int k = 1; k < n; k <<= 1) {
            final int kk = k;
            Arrays.sort(sa, (a, b) -> {
                if (rank[a] != rank[b]) return rank[a] - rank[b];
                int ra = a + kk < n ? rank[a+kk] : -1;
                int rb = b + kk < n ? rank[b+kk] : -1;
                return ra - rb;
            });
            tmp[sa[0]] = 0;
            for (int i = 1; i < n; i++) {
                tmp[sa[i]] = tmp[sa[i-1]];
                if (rank[sa[i-1]] != rank[sa[i]] || 
                    (sa[i-1]+kk<n ? rank[sa[i-1]+kk] : -1) != (sa[i]+kk<n ? rank[sa[i]+kk] : -1)) 
                    tmp[sa[i]]++;
            }
            System.arraycopy(tmp, 0, rank, 0, n);
        }
        return sa;
    }

    public static void main(String[] args) {
        String s = "banana";
        int[] sa = buildSuffixArray(s);
        System.out.println(Arrays.toString(sa));
    }
}
