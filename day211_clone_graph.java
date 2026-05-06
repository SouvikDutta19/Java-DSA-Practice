import java.util.*;

public class day211_clone_graph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node(){
            neighbors = new ArrayList<>();
        }

        public Node(int val){
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    public static Node cloneGraph(Node node){

        if(node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(node);
        map.put(node, new Node(node.val));

        while(!q.isEmpty()){

            Node curr = q.poll();

            for(Node nei : curr.neighbors){

                if(!map.containsKey(nei)){
                    map.put(nei, new Node(nei.val));
                    q.add(nei);
                }

                map.get(curr).neighbors.add(map.get(nei));
            }
        }
        return map.get(node);
    }
}