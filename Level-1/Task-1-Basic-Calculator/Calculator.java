
import java.util.Scanner;

public class Calculator {

    // Addition
    public static double add(double a, double b) {
        return a + b;
    }

    // Subtraction
    public static double subtract(double a, double b) {
        return a - b;
    }

    // Multiplication
    public static double multiply(double a, double b) {
        return a * b;
    }

    // Division
    public static double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero!");
        }
        return a / b;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("       BASIC CALCULATOR");
        System.out.println("================================");

        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();

        System.out.println("\nSelect Operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        System.out.print("\nEnter your choice (1-4): ");
        int choice = input.nextInt();

        switch (choice) {

            case 1:
                System.out.println("Result: " + add(num1, num2));
                break;

            case 2:
                System.out.println("Result: " + subtract(num1, num2));
                break;

            case 3:
                System.out.println("Result: " + multiply(num1, num2));
                break;

            case 4:
                try {
                    System.out.println("Result: " + divide(num1, num2));
                } catch (ArithmeticException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break;

            default:
                System.out.println("Invalid operation choice!");
        }

        input.close();
    }
}
