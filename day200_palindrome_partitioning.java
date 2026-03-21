import java.util.*;

public class day200_palindrome_partitioning {

    public static List<List<String>> partition(String s){

        List<List<String>> result = new ArrayList<>();
        backtrack(s,0,new ArrayList<>(),result);
        return result;
    }

    static void backtrack(String s,int start,List<String> temp,List<List<String>> result){

        if(start == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start;i<s.length();i++){

            if(isPalindrome(s,start,i)){
                temp.add(s.substring(start,i+1));
                backtrack(s,i+1,temp,result);
                temp.remove(temp.size()-1);
            }
        }
    }

    static boolean isPalindrome(String s,int l,int r){
        while(l<r){
            if(s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }
}