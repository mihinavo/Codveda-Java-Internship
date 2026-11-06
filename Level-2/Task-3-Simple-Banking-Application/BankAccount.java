public class BankAccount {

    private String accountHolder;
    private int accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Deposit money
    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Deposit amount must be positive!");
        }
        else {
            balance += amount;
            System.out.println("Deposit successful!");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive!");
        }
        else if (amount > balance) {
            System.out.println("Insufficient funds!");
        }
        else {
            balance -= amount;
            System.out.println("Withdrawal successful!");
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Account Balance: " + balance);
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
