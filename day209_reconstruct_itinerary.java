import java.util.*;

public class day209_reconstruct_itinerary {

    public static List<String> findItinerary(List<List<String>> tickets){

        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for(List<String> t : tickets){
            map.putIfAbsent(t.get(0), new PriorityQueue<>());
            map.get(t.get(0)).add(t.get(1));
        }

        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", map, res);

        return res;
    }

    static void dfs(String src, Map<String, PriorityQueue<String>> map, LinkedList<String> res){

        PriorityQueue<String> pq = map.get(src);

        while(pq != null && !pq.isEmpty()){
            dfs(pq.poll(), map, res);
        }

        res.addFirst(src);
    }
}