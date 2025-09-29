import java.util.*;

public class day93_alien_dictionary {
    public static String alienOrder(String[] words) {
        Map<Character,Set<Character>> graph=new HashMap<>();
        Map<Character,Integer> indegree=new HashMap<>();
        for(String w:words) for(char c:w.toCharArray()) indegree.put(c,0);
        for(int i=0;i<words.length-1;i++){
            String w1=words[i], w2=words[i+1];
            if(w1.length()>w2.length() && w1.startsWith(w2)) return "";
            for(int j=0;j<Math.min(w1.length(),w2.length());j++){
                char c1=w1.charAt(j), c2=w2.charAt(j);
                if(c1!=c2){
                    graph.computeIfAbsent(c1,k->new HashSet<>());
                    if(graph.get(c1).add(c2)){
                        indegree.put(c2,indegree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q=new LinkedList<>();
        for(char c:indegree.keySet()) if(indegree.get(c)==0) q.add(c);
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            char cur=q.poll(); sb.append(cur);
            if(graph.containsKey(cur)){
                for(char nb:graph.get(cur)){
                    indegree.put(nb,indegree.get(nb)-1);
                    if(indegree.get(nb)==0) q.add(nb);
                }
            }
        }
        return sb.length()==indegree.size()?sb.toString():"";
    }
    public static void main(String[] args){
        String[] words={"wrt","wrf","er","ett","rftt"};
        System.out.println(alienOrder(words));
    }
}
