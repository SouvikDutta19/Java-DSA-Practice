import java.io.*;
import java.util.*;

public class day67_floyd_warshall {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.parseInt(st.nextToken());
                if(i!=j && dist[i][j]==0) dist[i][j]=100000000;
            }
        }
        for(int k=0;k<n;k++)
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);

        for(int i=0;i<n;i++) System.out.println(Arrays.toString(dist[i]));
    }
}
