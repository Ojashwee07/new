class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000.0);
        System.out.println("Balance: " + myAccount.getBalance());
    }
}