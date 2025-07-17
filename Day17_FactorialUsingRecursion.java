public class Day17_FactorialUsingRecursion {
    public static long factorial(int n) {
        if (n <= 1)
            return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int num = 10;
        System.out.println("Factorial of " + num + " is: " + factorial(num));
    }
}
