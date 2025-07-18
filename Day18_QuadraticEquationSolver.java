public class Day18_QuadraticEquationSolver {
    public static void solve(double a, double b, double c) {
        double discriminant = b*b - 4*a*c;

        if (a == 0) {
            System.out.println("Not a quadratic equation.");
            return;
        }

        System.out.println("Equation: " + a + "x² + " + b + "x + " + c + " = 0");

        if (discriminant > 0) {
            double r1 = (-b + Math.sqrt(discriminant)) / (2*a);
            double r2 = (-b - Math.sqrt(discriminant)) / (2*a);
            System.out.println("Roots are real and distinct: " + r1 + ", " + r2);
        } else if (discriminant == 0) {
            double r = -b / (2*a);
            System.out.println("Roots are real and equal: " + r);
        } else {
            double real = -b / (2*a);
            double imag = Math.sqrt(-discriminant) / (2*a);
            System.out.println("Roots are complex: " + real + " ± " + imag + "i");
        }
    }

    public static void main(String[] args) {
        solve(1, -3, 2);
        solve(1, 2, 1);
        solve(1, 1, 1);
    }
}
