public class day38_zalgorithm {
    public static int[] calculateZ(String str) {
        int n = str.length();
        int[] Z = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i > r) {
                l = r = i;
                while (r < n && str.charAt(r - l) == str.charAt(r)) r++;
                Z[i] = r - l;
                r--;
            } else {
                int k = i - l;
                if (Z[k] < r - i + 1) Z[i] = Z[k];
                else {
                    l = i;
                    while (r < n && str.charAt(r - l) == str.charAt(r)) r++;
                    Z[i] = r - l;
                    r--;
                }
            }
        }
        return Z;
    }

    public static void main(String[] args) {
        String text = "aabxaabxcaabxaabxay";
        int[] z = calculateZ(text);
        System.out.print("Z-array: ");
        for (int i : z) System.out.print(i + " ");
    }
}
