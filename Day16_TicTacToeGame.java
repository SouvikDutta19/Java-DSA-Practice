import java.util.Scanner;

public class Day16_TicTacToeGame {
    private static final char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    private static void printBoard() {
        for (char[] row : board) {
            for (char c : row) System.out.print("|" + c);
            System.out.println("|");
        }
    }

    private static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++)
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player))
                return true;
        return (board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
               (board[0][2] == player && board[1][1] == player && board[2][0] == player);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char player = 'X';
        int moves = 0;

        while (moves < 9) {
            printBoard();
            System.out.println("Player " + player + ", enter row and column (0-2): ");
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            if (board[r][c] == ' ') {
                board[r][c] = player;
                moves++;
                if (checkWin(player)) {
                    printBoard();
                    System.out.println("🎉 Player " + player + " wins!");
                    return;
                }
                player = (player == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Cell already occupied, try again.");
            }
        }

        printBoard();
        System.out.println("It's a draw!");
        scanner.close();
    }
}
