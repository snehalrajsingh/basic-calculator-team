package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Basic Calculator ===");
        System.out.print("Enter first number: ");
        double a = readNumber(scanner);

        System.out.print("Enter operator (+, -, *, /): ");
        String operator = scanner.next().trim();

        System.out.print("Enter second number: ");
        double b = readNumber(scanner);

        try {
            double result;
            switch (operator) {
                case "+":
                    result = Addition.add(a, b);
                    break;
                case "-":
                    result = Subtraction.subtract(a, b);
                    break;
                case "*":
                    result = Multiplication.multiply(a, b);
                    break;
                case "/":
                    result = Division.divide(a, b);
                    break;
                default:
                    System.out.println("Error: Unsupported operator.");
                    return;
            }
            System.out.println("Result: " + result);
        } catch (ArithmeticException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static double readNumber(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
