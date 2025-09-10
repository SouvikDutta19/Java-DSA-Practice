import java.util.*;

public class day71_chinese_postman {
    static int[][] graph={
        {0,1,1,0},
        {1,0,1,1},
        {1,1,0,1},
        {0,1,1,0}
    };

    static boolean isEulerian(){
        int odd=0;
        for(int i=0;i<graph.length;i++){
            int deg=0; for(int j=0;j<graph.length;j++) deg+=graph[i][j];
            if(deg%2!=0) odd++;
        }
        return odd==0;
    }

    public static void main(String[] args){
        if(isEulerian()) System.out.println("Graph has Eulerian circuit");
        else System.out.println("Graph not Eulerian");
    }
}
