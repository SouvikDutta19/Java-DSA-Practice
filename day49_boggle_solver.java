import java.util.*;

public class day49_boggle_solver {
    static final int M = 3, N = 3;

    static boolean isWord(String str, Set<String> dict) {
        return dict.contains(str);
    }

    static void findWordsUtil(char[][] boggle, boolean[][] visited, int i, int j, String str, Set<String> dict) {
        visited[i][j] = true;
        str = str + boggle[i][j];

        if (isWord(str, dict))
            System.out.println(str);

        for (int row = i - 1; row <= i + 1 && row < M; row++) {
            for (int col = j - 1; col <= j + 1 && col < N; col++) {
                if (row >= 0 && col >= 0 && !visited[row][col]) {
                    findWordsUtil(boggle, visited, row, col, str, dict);
                }
            }
        }

        str = str.substring(0, str.length() - 1);
        visited[i][j] = false;
    }

    static void findWords(char[][] boggle, Set<String> dict) {
        boolean[][] visited = new boolean[M][N];
        String str = "";
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                findWordsUtil(boggle, visited, i, j, str, dict);
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>(Arrays.asList("GEEKS", "FOR", "QUIZ", "GO"));
        char[][] boggle = { { 'G', 'I', 'Z' }, { 'U', 'E', 'K' }, { 'Q', 'S', 'E' } };
        findWords(boggle, dict);
    }
}
