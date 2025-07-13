import java.util.Arrays;

public class Day13_MergeTwoSortedArrays {

    public static int[] mergeSorted(int[] a, int[] b) {
        int[] merged = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            merged[k++] = a[i] < b[j] ? a[i++] : b[j++];
        }
        while (i < a.length) merged[k++] = a[i++];
        while (j < b.length) merged[k++] = b[j++];

        return merged;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};
        System.out.println("📦 Merged: " + Arrays.toString(mergeSorted(a, b)));
    }
}
