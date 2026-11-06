import java.util.Scanner;

public class Factorial {

    // Recursive method
    public static long calculateFactorial(int number) {

        if (number == 0 || number == 1) {
            return 1;
        }

        return number * calculateFactorial(number - 1);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("   FACTORIAL CALCULATOR");
        System.out.println("==============================");

        System.out.print("Enter a number: ");
        int number = input.nextInt();

        if (number < 0) {
            System.out.println("Error: Factorial is not defined for negative numbers.");
        }
        else if (number > 20) {
            System.out.println("Error: Please enter a number between 0 and 20.");
        }
        else {
            long result = calculateFactorial(number);

            System.out.println("Factorial of " + number + " is: " + result);
        }

        input.close();
    }
}
