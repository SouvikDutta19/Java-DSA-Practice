public class Day11_PrintNumberTriangle {

    public static void main(String[] args) {
        int rows = 5, num = 1;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }
}
