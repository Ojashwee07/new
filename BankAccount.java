public class BankAccount {
    public String accountNumber;
    public  String accountHolder;
    public  double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of " + amount + " successful. New balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawal of " + amount + " successful. New balance: " + balance);
            } else {
                System.out.println("Insufficient balance. Current balance: " + balance);
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println(); // For separation
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("123456", "Rishi Dayal", 1000.0);
        BankAccount account2 = new BankAccount("789012", "Ojashwee", 500.0);

        account1.displayAccountDetails();
        account2.displayAccountDetails();

        account1.deposit(200.0);
        account1.withdraw(150.0);
        account1.withdraw(2000.0);

        account2.deposit(-50.0);
        account2.withdraw(600.0);
        account2.withdraw(300.0);

        account1.displayAccountDetails();
        account2.displayAccountDetails();
    }
}