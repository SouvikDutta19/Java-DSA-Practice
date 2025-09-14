import java.util.*;

public class day76_dinic_maxflow {
    static class Edge{
        int v,flow,cap,rev;
        Edge(int v,int cap,int rev){this.v=v;this.cap=cap;this.flow=0;this.rev=rev;}
    }

    static class Graph{
        int V;
        List<Edge>[] adj;
        Graph(int V){
            this.V=V; adj=new ArrayList[V];
            for(int i=0;i<V;i++) adj[i]=new ArrayList<>();
        }
        void addEdge(int u,int v,int cap){
            Edge a=new Edge(v,cap,adj[v].size());
            Edge b=new Edge(u,0,adj[u].size());
            adj[u].add(a); adj[v].add(b);
        }
        boolean BFS(int s,int t,int[] level){
            Arrays.fill(level,-1); level[s]=0;
            Queue<Integer> q=new LinkedList<>(); q.add(s);
            while(!q.isEmpty()){
                int u=q.poll();
                for(Edge e:adj[u]){
                    if(level[e.v]<0 && e.flow<e.cap){
                        level[e.v]=level[u]+1; q.add(e.v);
                    }
                }
            }
            return level[t]>=0;
        }
        int sendFlow(int u,int flow,int t,int[] start,int[] level){
            if(u==t) return flow;
            for(;start[u]<adj[u].size();start[u]++){
                Edge e=adj[u].get(start[u]);
                if(level[e.v]==level[u]+1 && e.flow<e.cap){
                    int curr=sendFlow(e.v,Math.min(flow,e.cap-e.flow),t,start,level);
                    if(curr>0){
                        e.flow+=curr; adj[e.v].get(e.rev).flow-=curr; return curr;
                    }
                }
            }
            return 0;
        }
        int dinic(int s,int t){
            if(s==t) return -1;
            int total=0;
            int[] level=new int[V];
            while(BFS(s,t,level)){
                int[] start=new int[V];
                while(true){
                    int flow=sendFlow(s,Integer.MAX_VALUE,t,start,level);
                    if(flow<=0) break;
                    total+=flow;
                }
            }
            return total;
        }
    }

    public static void main(String[] args){
        Graph g=new Graph(6);
        g.addEdge(0,1,16); g.addEdge(0,2,13);
        g.addEdge(1,2,10); g.addEdge(1,3,12);
        g.addEdge(2,1,4); g.addEdge(2,4,14);
        g.addEdge(3,2,9); g.addEdge(3,5,20);
        g.addEdge(4,3,7); g.addEdge(4,5,4);
        System.out.println("Max Flow: "+g.dinic(0,5));
    }
}
