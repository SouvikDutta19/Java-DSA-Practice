import java.util.Scanner;

public class Day5_BinaryToDecimal {

    public static int convertBinaryToDecimal(String binary) {
        return Integer.parseInt(binary, 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binary = sc.nextLine();

        try {
            int decimal = convertBinaryToDecimal(binary);
            System.out.println("🔁 Decimal equivalent: " + decimal);
        } catch (NumberFormatException e) {
            System.out.println("❌ Invalid binary number.");
        }

        sc.close();
    }
}
