import java.util.*;

public class day209_word_break_ii {

    public static List<String> wordBreak(String s, List<String> wordDict){

        Set<String> set = new HashSet<>(wordDict);
        Map<String,List<String>> memo = new HashMap<>();

        return dfs(s,set,memo);
    }

    static List<String> dfs(String s, Set<String> set, Map<String,List<String>> memo){

        if(memo.containsKey(s))
            return memo.get(s);

        List<String> res = new ArrayList<>();

        if(s.isEmpty()){
            res.add("");
            return res;
        }

        for(String word : set){

            if(s.startsWith(word)){

                List<String> sub = dfs(s.substring(word.length()), set, memo);

                for(String str : sub){
                    res.add(word + (str.isEmpty() ? "" : " " + str));
                }
            }
        }

        memo.put(s,res);
        return res;
    }
}