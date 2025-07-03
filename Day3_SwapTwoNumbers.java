import java.util.Scanner;

public class Day3_SwapTwoNumbers {

    public static void swapWithoutTemp(int a, int b) {
        System.out.println("🔄 Before Swap: a = " + a + ", b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("✅ After Swap: a = " + a + ", b = " + b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of a: ");
        int a = sc.nextInt();
        System.out.print("Enter value of b: ");
        int b = sc.nextInt();

        swapWithoutTemp(a, b);

        sc.close();
    }
}
