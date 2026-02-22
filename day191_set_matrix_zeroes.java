import java.util.Arrays;

public class Day191SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][0] == 0)
                firstColZero = true;

        for (int j = 0; j < matrix[0].length; j++)
            if (matrix[0][j] == 0)
                firstRowZero = true;

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++)
            if (matrix[i][0] == 0)
                Arrays.fill(matrix[i], 0);

        for (int j = 1; j < matrix[0].length; j++)
            if (matrix[0][j] == 0)
                for (int i = 0; i < matrix.length; i++)
                    matrix[i][j] = 0;

        if (firstRowZero)
            Arrays.fill(matrix[0], 0);

        if (firstColZero)
            for (int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };

        setZeroes(matrix);

        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }
}