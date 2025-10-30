// day123_permutationsequence.java
import java.util.*;

public class day123_permutationsequence {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            fact *= i;
        }
        k--;
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            fact /= i;
            int index = k / fact;
            sb.append(numbers.get(index));
            numbers.remove(index);
            k %= fact;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        day123_permutationsequence obj = new day123_permutationsequence();
        System.out.println("Permutation Sequence for n=3, k=3: " + obj.getPermutation(3, 3));
    }
}
