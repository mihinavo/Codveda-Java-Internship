
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1;
        int maxAttempts = 7;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("=================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("=================================");
        System.out.println("I have selected a number between 1 and 100.");
        System.out.println("You have " + maxAttempts + " attempts to guess it.");

        while (attempts < maxAttempts) {

            System.out.print("\nEnter your guess: ");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input! Please enter a whole number.");
                input.next();
                continue;
            }

            int guess = input.nextInt();

            if (guess < 1 || guess > 100) {
                System.out.println("Please enter a number between 1 and 100.");
                continue;
            }

            attempts++;

            if (guess == secretNumber) {
                System.out.println("Congratulations! You guessed correctly!");
                System.out.println("Number of attempts: " + attempts);
                guessedCorrectly = true;
                break;
            } 
            else if (guess > secretNumber) {
                System.out.println("Too high! Try a smaller number.");
            } 
            else {
                System.out.println("Too low! Try a bigger number.");
            }

            System.out.println("Attempts remaining: " + (maxAttempts - attempts));
        }

        if (!guessedCorrectly) {
            System.out.println("\nGame Over!");
            System.out.println("The correct number was: " + secretNumber);
        }

        input.close();
    }
}
