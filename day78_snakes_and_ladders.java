import java.util.*;

public class day78_snakes_and_ladders {
    public static int snakesAndLadders(int[][] board) {
        int n=board.length;
        int[] moves=new int[n*n+1];
        Arrays.fill(moves,-1);
        int idx=1; boolean leftToRight=true;
        for(int r=n-1;r>=0;r--) {
            if(leftToRight) {
                for(int c=0;c<n;c++) moves[idx++]=board[r][c];
            } else {
                for(int c=n-1;c>=0;c--) moves[idx++]=board[r][c];
            }
            leftToRight=!leftToRight;
        }
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited=new boolean[n*n+1];
        q.offer(1); visited[1]=true;
        int steps=0;
        while(!q.isEmpty()) {
            for(int sz=q.size();sz>0;sz--) {
                int curr=q.poll();
                if(curr==n*n) return steps;
                for(int dice=1;dice<=6;dice++) {
                    int next=curr+dice;
                    if(next<=n*n) {
                        if(moves[next]!=-1) next=moves[next];
                        if(!visited[next]) {
                            visited[next]=true;
                            q.offer(next);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] board = {
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,35,-1,-1,13,-1},
            {-1,-1,-1,-1,-1,-1},
            {-1,15,-1,-1,-1,-1}
        };
        System.out.println("Minimum moves: "+snakesAndLadders(board));
    }
}
