package calculator;

public class Division {

    public static double divide(double a, double b) {
        System.out.println("Performing Division...");

        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        return a / b;
    }
}
