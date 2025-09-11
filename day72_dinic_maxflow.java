import java.util.*;

public class day72_dinic_maxflow {
    static class Edge {
        int v, cap, flow, rev;
        Edge(int v,int cap,int rev){this.v=v;this.cap=cap;this.flow=0;this.rev=rev;}
    }

    static class Dinic {
        int V; List<Edge>[] adj; int[] level, it;
        Dinic(int V){this.V=V; adj=new ArrayList[V]; for(int i=0;i<V;i++) adj[i]=new ArrayList<>();}
        void addEdge(int u,int v,int cap){
            Edge a=new Edge(v,cap,adj[v].size());
            Edge b=new Edge(u,0,adj[u].size());
            adj[u].add(a); adj[v].add(b);
        }
        boolean bfs(int s,int t){
            level=new int[V]; Arrays.fill(level,-1);
            Queue<Integer> q=new LinkedList<>(); q.add(s); level[s]=0;
            while(!q.isEmpty()){
                int u=q.poll();
                for(Edge e:adj[u]) if(level[e.v]<0 && e.flow<e.cap){
                    level[e.v]=level[u]+1; q.add(e.v);
                }
            }
            return level[t]>=0;
        }
        int dfs(int u,int t,int f){
            if(u==t) return f;
            for(;it[u]<adj[u].size();it[u]++){
                Edge e=adj[u].get(it[u]);
                if(e.flow<e.cap && level[e.v]==level[u]+1){
                    int df=dfs(e.v,t,Math.min(f,e.cap-e.flow));
                    if(df>0){
                        e.flow+=df;
                        adj[e.v].get(e.rev).flow-=df;
                        return df;
                    }
                }
            }
            return 0;
        }
        int maxflow(int s,int t){
            int flow=0;
            while(bfs(s,t)){
                it=new int[V];
                while(true){
                    int f=dfs(s,t,Integer.MAX_VALUE);
                    if(f==0) break; flow+=f;
                }
            }
            return flow;
        }
    }

    public static void main(String[] args){
        Dinic d=new Dinic(6);
        d.addEdge(0,1,16);
        d.addEdge(0,2,13);
        d.addEdge(1,2,10);
        d.addEdge(2,1,4);
        d.addEdge(1,3,12);
        d.addEdge(2,4,14);
        d.addEdge(3,2,9);
        d.addEdge(4,3,7);
        d.addEdge(3,5,20);
        d.addEdge(4,5,4);
        System.out.println("Max Flow: "+d.maxflow(0,5));
    }
}
