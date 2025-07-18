class BankAccount {
    private String accountHolder;
    private double balance;

    BankAccount(String name, double initialBalance) {
        accountHolder = name;
        balance = initialBalance;
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    void displayBalance() {
        System.out.println(accountHolder + "'s Balance: " + balance);
    }
}

public class Day18_BankAccountSimulation {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Souvik", 5000);
        acc.displayBalance();
        acc.deposit(1500);
        acc.withdraw(3000);
        acc.withdraw(4000);
        acc.displayBalance();
    }
}
