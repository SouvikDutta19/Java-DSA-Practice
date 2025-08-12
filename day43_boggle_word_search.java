import java.util.*;

public class day43_boggle_word_search {
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static int M, N;

    public static void findWords(char[][] board, boolean[][] visited, int i, int j, String str, Set<String> dictionary) {
        visited[i][j] = true;
        str = str + board[i][j];

        if (dictionary.contains(str))
            System.out.println(str);

        for (int row = 0; row < 8; row++) {
            int newX = i + dx[row];
            int newY = j + dy[row];
            if (isSafe(newX, newY, visited))
                findWords(board, visited, newX, newY, str, dictionary);
        }

        visited[i][j] = false;
    }

    public static boolean isSafe(int x, int y, boolean[][] visited) {
        return (x >= 0 && x < M && y >= 0 && y < N && !visited[x][y]);
    }

    public static void main(String[] args) {
        char[][] board = {
            {'G','I','Z'},
            {'U','E','K'},
            {'Q','S','E'}
        };

        Set<String> dictionary = new HashSet<>(Arrays.asList("GEEKS", "FOR", "QUIZ", "GO"));
        M = board.length;
        N = board[0].length;

        boolean[][] visited = new boolean[M][N];
        String str = "";

        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                findWords(board, visited, i, j, str, dictionary);
    }
}
