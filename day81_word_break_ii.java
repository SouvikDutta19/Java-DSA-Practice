import java.util.*;

public class day81_word_break_ii {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        return backtrack(s,new HashSet<>(wordDict),new HashMap<>());
    }

    private static List<String> backtrack(String s,Set<String> dict,Map<String,List<String>> memo){
        if(memo.containsKey(s)) return memo.get(s);
        List<String> res=new ArrayList<>();
        if(dict.contains(s)) res.add(s);
        for(int i=1;i<s.length();i++) {
            String prefix=s.substring(0,i);
            if(dict.contains(prefix)) {
                List<String> rest=backtrack(s.substring(i),dict,memo);
                for(String str:rest) res.add(prefix+" "+str);
            }
        }
        memo.put(s,res);
        return res;
    }

    public static void main(String[] args) {
        List<String> dict=Arrays.asList("cat","cats","and","sand","dog");
        System.out.println(wordBreak("catsanddog",dict));
    }
}
