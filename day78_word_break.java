import java.util.*;

public class day78_word_break {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict=new HashSet<>(wordDict);
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for(int i=1;i<=s.length();i++) {
            for(int j=0;j<i;j++) {
                if(dp[j] && dict.contains(s.substring(j,i))) {
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> dict=Arrays.asList("leet","code");
        System.out.println("Can segment? "+wordBreak("leetcode",dict));
    }
}
