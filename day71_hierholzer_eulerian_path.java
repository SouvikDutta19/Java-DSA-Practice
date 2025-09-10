import java.util.*;

public class day71_hierholzer_eulerian_path {
    static void printEulerTour(List<List<Integer>> adj){
        Stack<Integer> currPath=new Stack<>();
        List<Integer> circuit=new ArrayList<>();
        currPath.push(0);
        int currV=0;
        while(!currPath.isEmpty()){
            if(adj.get(currV).size()>0){
                currPath.push(currV);
                int nextV=adj.get(currV).remove(0);
                adj.get(nextV).remove((Integer)currV);
                currV=nextV;
            }else{
                circuit.add(currV);
                currV=currPath.pop();
            }
        }
        Collections.reverse(circuit);
        System.out.println(circuit);
    }

    public static void main(String[] args){
        int V=3;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        adj.get(0).add(1); adj.get(1).add(0);
        adj.get(0).add(2); adj.get(2).add(0);
        adj.get(1).add(2); adj.get(2).add(1);
        printEulerTour(adj);
    }
}
