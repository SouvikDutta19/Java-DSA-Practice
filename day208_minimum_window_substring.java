import java.util.*;

public class day208_minimum_window_substring {

    public static String minWindow(String s, String t){

        Map<Character,Integer> map = new HashMap<>();

        for(char c : t.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);

        int left = 0, count = t.length();
        int minLen = Integer.MAX_VALUE, start = 0;

        for(int right=0; right<s.length(); right++){

            char c = s.charAt(right);

            if(map.containsKey(c)){
                if(map.get(c) > 0) count--;
                map.put(c, map.get(c)-1);
            }

            while(count == 0){

                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    start = left;
                }

                char l = s.charAt(left);

                if(map.containsKey(l)){
                    map.put(l, map.get(l)+1);
                    if(map.get(l) > 0) count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" :
                s.substring(start, start + minLen);
    }
}