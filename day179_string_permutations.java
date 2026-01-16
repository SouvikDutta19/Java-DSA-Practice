public class day179_string_permutations {

    public static void permute(char[] arr, int l) {
        if (l == arr.length) {
            System.out.println(String.valueOf(arr));
            return;
        }

        for (int i = l; i < arr.length; i++) {
            swap(arr, l, i);
            permute(arr, l + 1);
            swap(arr, l, i);
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String s = "ABC";
        permute(s.toCharArray(), 0);
    }
}