import java.util.Scanner;

public class Day6_SwapTwoNumbers {

    public static void swapNumbers(int a, int b) {
        System.out.println("🔁 Before Swap → a: " + a + ", b: " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("🔁 After Swap → a: " + a + ", b: " + b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter two numbers (a and b): ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        swapNumbers(a, b);

        sc.close();
    }
}
