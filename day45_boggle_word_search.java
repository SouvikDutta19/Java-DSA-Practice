import java.util.*;

public class day45_boggle_word_search {

    static int M, N;
    static String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GO"};

    static boolean isWord(String str) {
        for (String word : dictionary) {
            if (word.equals(str))
                return true;
        }
        return false;
    }

    static void findWords(char[][] boggle) {
        M = boggle.length;
        N = boggle[0].length;
        boolean[][] visited = new boolean[M][N];
        String str = "";

        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                findWordsUtil(boggle, visited, i, j, str);
    }

    static void findWordsUtil(char[][] boggle, boolean[][] visited, int i, int j, String str) {
        visited[i][j] = true;
        str = str + boggle[i][j];

        if (isWord(str)) System.out.println(str);

        for (int row = i - 1; row <= i + 1 && row < M; row++)
            for (int col = j - 1; col <= j + 1 && col < N; col++)
                if (row >= 0 && col >= 0 && !visited[row][col])
                    findWordsUtil(boggle, visited, row, col, str);

        visited[i][j] = false;
    }

    public static void main(String[] args) {
        char[][] boggle = {{'G','I','Z'}, {'U','E','K'}, {'Q','S','E'}};
        System.out.println("Words found:");
        findWords(boggle);
    }
}
