import java.util.*;

// Z-algorithm for pattern matching and Z-array computation (O(n))
public class day117_z_algorithm {
    static int[] zArray(String s) {
        int n = s.length();
        int[] z = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            if (i <= r) z[i] = Math.min(r - i + 1, z[i - l]);
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) z[i]++;
            if (i + z[i] - 1 > r) { l = i; r = i + z[i] - 1; }
        }
        z[0] = n;
        return z;
    }

    static List<Integer> findOccurrences(String txt, String pat) {
        String concat = pat + "$" + txt;
        int[] z = zArray(concat);
        List<Integer> occ = new ArrayList<>();
        int m = pat.length();
        for (int i = m + 1; i < z.length; i++)
            if (z[i] == m) occ.add(i - (m + 1));
        return occ;
    }

    public static void main(String[] args) {
        String txt = "abxabcabcaby";
        String pat = "abcaby";
        System.out.println("Z-array: " + Arrays.toString(zArray(txt)));
        System.out.println("Occurrences of pattern: " + findOccurrences(txt, pat));
    }
}
