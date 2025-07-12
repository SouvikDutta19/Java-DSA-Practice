public class Day12_PascalTriangle {

    public static void printPascal(int n) {
        for (int line = 0; line < n; line++) {
            int num = 1;
            for (int j = 0; j < n - line; j++)
                System.out.print(" ");
            for (int i = 0; i <= line; i++) {
                System.out.print(num + " ");
                num = num * (line - i) / (i + 1);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int rows = 5;
        System.out.println("🧮 Pascal's Triangle:");
        printPascal(rows);
    }
}
