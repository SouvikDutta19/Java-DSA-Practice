public class Day17_CheckPalindromeNumber {
    public static boolean isPalindrome(int number) {
        int original = number, reversed = 0;
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return original == reversed;
    }

    public static void main(String[] args) {
        int num = 12321;
        System.out.println(num + " is palindrome? " + isPalindrome(num));
    }
}
