import java.util.*;

public class day213_find_all_anagrams {

    public static List<Integer> findAnagrams(String s, String p){

        List<Integer> result = new ArrayList<>();

        if(s.length() < p.length())
            return result;

        int[] target = new int[26];
        int[] window = new int[26];

        for(char c : p.toCharArray())
            target[c-'a']++;

        int k = p.length();

        for(int i=0;i<s.length();i++){

            window[s.charAt(i)-'a']++;

            if(i >= k)
                window[s.charAt(i-k)-'a']--;

            if(Arrays.equals(target, window))
                result.add(i-k+1);
        }

        return result;
    }
}