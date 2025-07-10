import java.util.Scanner;

public class Day10_DecimalToBinary {

    public static String toBinary(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int n = sc.nextInt();

        System.out.println("💡 Binary: " + toBinary(n));
        sc.close();
    }
}
