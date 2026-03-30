public class day205_floyd_warshall {

    public static void floydWarshall(int[][] graph){

        int n = graph.length;

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){

                    if(graph[i][k] + graph[k][j] < graph[i][j])
                        graph[i][j] = graph[i][k] + graph[k][j];
                }
            }
        }
    }
}