import java.util.*;

public class day88_min_window_substring {
    static String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) need.put(c, need.getOrDefault(c,0)+1);
        int have=0, needCount=need.size();
        Map<Character,Integer> window=new HashMap<>();
        int l=0,resLen=Integer.MAX_VALUE,resL=0,resR=0;
        for (int r=0;r<s.length();r++){
            char c=s.charAt(r);
            window.put(c,window.getOrDefault(c,0)+1);
            if(need.containsKey(c) && window.get(c).intValue()==need.get(c).intValue()) have++;
            while(have==needCount){
                if(r-l+1<resLen){resLen=r-l+1;resL=l;resR=r;}
                char cl=s.charAt(l);
                window.put(cl,window.get(cl)-1);
                if(need.containsKey(cl) && window.get(cl)<need.get(cl)) have--;
                l++;
            }
        }
        return resLen==Integer.MAX_VALUE?"":s.substring(resL,resR+1);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));
    }
}
