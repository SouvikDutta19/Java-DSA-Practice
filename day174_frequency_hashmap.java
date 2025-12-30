import java.util.*;

public class day174_frequency_hashmap {
    public static void main(String[] args){
        int[] arr={2,3,2,4,3,5,2};
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int x:arr) map.put(x,map.getOrDefault(x,0)+1);
        System.out.println(map);
    }
}