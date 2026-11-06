import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BankAccount account = new BankAccount("Navodya", 1001, 10000.00);

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("     SIMPLE BANKING SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    System.out.println("Account Holder: "
                            + account.getAccountHolder());
                    System.out.println("Account Number: "
                            + account.getAccountNumber());
                    account.checkBalance();
                    break;

                case 5:
                    System.out.println("Thank you for using our banking system!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}
