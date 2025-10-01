public class day95_factorial {
    public static long factorial(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int num = 6;
        System.out.println("Factorial of " + num + " = " + factorial(num));
    }
}
