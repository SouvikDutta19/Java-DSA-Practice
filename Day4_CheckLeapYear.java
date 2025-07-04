import java.util.Scanner;

public class Day4_CheckLeapYear {

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = sc.nextInt();

        if (isLeapYear(year)) {
            System.out.println("✅ " + year + " is a leap year.");
        } else {
            System.out.println("❌ " + year + " is not a leap year.");
        }

        sc.close();
    }
}
