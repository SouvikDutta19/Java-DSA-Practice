public class day176_check_palindrome_string {

    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "madam";
        System.out.println(isPalindrome(s));
    }
}