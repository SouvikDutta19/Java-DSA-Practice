public class day72_union_find {
    static int[] parent,rank;

    static void makeSet(int n){ parent=new int[n]; rank=new int[n]; for(int i=0;i<n;i++) parent[i]=i; }
    static int find(int x){ return parent[x]==x?x:(parent[x]=find(parent[x])); }
    static void union(int x,int y){
        int rx=find(x), ry=find(y);
        if(rx!=ry){
            if(rank[rx]<rank[ry]) parent[rx]=ry;
            else if(rank[ry]<rank[rx]) parent[ry]=rx;
            else {parent[ry]=rx; rank[rx]++;}
        }
    }

    public static void main(String[] args){
        makeSet(5);
        union(0,1); union(1,2); union(3,4);
        System.out.println(find(2)==find(0));
        System.out.println(find(2)==find(3));
    }
}
