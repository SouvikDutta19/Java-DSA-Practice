import java.util.Scanner;

public class Day6_DecimalToBinary {

    public static String convertToBinary(int num) {
        return Integer.toBinaryString(num);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        int number = sc.nextInt();

        String binary = convertToBinary(number);
        System.out.println("💡 Binary representation: " + binary);

        sc.close();
    }
}
