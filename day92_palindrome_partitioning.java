import java.util.*;

public class day92_palindrome_partitioning {
    static List<List<String>> result = new ArrayList<>();
    public static List<List<String>> partition(String s) {
        backtrack(s,0,new ArrayList<>());
        return result;
    }
    static void backtrack(String s,int start,List<String> temp){
        if(start==s.length()){ result.add(new ArrayList<>(temp)); return; }
        for(int end=start+1;end<=s.length();end++){
            if(isPalindrome(s,start,end-1)){
                temp.add(s.substring(start,end));
                backtrack(s,end,temp);
                temp.remove(temp.size()-1);
            }
        }
    }
    static boolean isPalindrome(String s,int l,int r){
        while(l<r) if(s.charAt(l++)!=s.charAt(r--)) return false;
        return true;
    }
    public static void main(String[] args){
        System.out.println(partition("aab"));
    }
}
