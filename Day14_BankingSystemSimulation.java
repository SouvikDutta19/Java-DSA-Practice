abstract class BankAccount {
    protected String accountHolder;
    protected int accountNumber;
    protected double balance;

    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public void showDetails() {
        System.out.println("👤 Account Holder: " + accountHolder);
        System.out.println("🏦 Account Number: " + accountNumber);
        System.out.println("💰 Balance: ₹" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountHolder, int accountNumber, double balance) {
        super(accountHolder, accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        balance += balance * INTEREST_RATE;
        System.out.println("✅ Deposited ₹" + amount + " with interest. New balance: ₹" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("💸 Withdrew ₹" + amount + ". New balance: ₹" + balance);
        }
    }
}

class CurrentAccount extends BankAccount {
    private static final double OVERDRAFT_LIMIT = 10000;

    public CurrentAccount(String accountHolder, int accountNumber, double balance) {
        super(accountHolder, accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("✅ Deposited ₹" + amount + ". New balance: ₹" + balance);
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance + OVERDRAFT_LIMIT) {
            System.out.println("❌ Overdraft limit exceeded!");
        } else {
            balance -= amount;
            System.out.println("💸 Withdrew ₹" + amount + ". New balance: ₹" + balance);
        }
    }
}

public class Day14_BankingSystemSimulation {
    public static void main(String[] args) {
        System.out.println("🏦 Savings Account Operations:");
        BankAccount sa = new SavingsAccount("Souvik Dutta", 123456, 5000);
        sa.showDetails();
        sa.deposit(1000);
        sa.withdraw(2000);
        sa.showDetails();

        System.out.println("\n🏦 Current Account Operations:");
        BankAccount ca = new CurrentAccount("Souvik Dutta", 654321, 10000);
        ca.showDetails();
        ca.withdraw(15000); // Within overdraft
        ca.withdraw(5000);  // Exceeding overdraft
        ca.showDetails();
    }
}
