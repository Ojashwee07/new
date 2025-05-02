class BankAccount1 {
    private final double balance;
    public BankAccount1(double initialBalance) {
        this.balance = initialBalance;
    }
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        BankAccount1 myAccount = new BankAccount1(1000.0);
        System.out.println("Balance: " + myAccount.getBalance());
    }
}