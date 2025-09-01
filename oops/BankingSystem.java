// Transaction interface
interface Transaction {
    void deposit(double amount);
    void withdraw(double amount);
}
// Base class
abstract class Account implements Transaction {
    private String accountNumber;
    protected double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }

    public void displayBalance() {
        System.out.println("Account " + accountNumber + " Balance: " + balance);
    }
}
// Savings Account
class SavingsAccount extends Account {
    private double withdrawalLimit = 5000;

    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " into Savings Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount > withdrawalLimit) {
            System.out.println("Withdrawal exceeds limit for Savings Account!");
        } else if (amount > balance) {
            System.out.println("Insufficient balance in Savings Account!");
        } else {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Savings Account.");
        }
    }
}
// Checking Account
class CheckingAccount extends Account {
    private double overdraftLimit = 2000;

    public CheckingAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + " into Checking Account.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount > balance + overdraftLimit) {
            System.out.println("Withdrawal exceeds overdraft limit for Checking Account!");
        } else {
            balance -= amount;
            System.out.println("Withdrew " + amount + " from Checking Account.");
        }
    }
}
// Main App
public class BankingApp {
    public static void main(String[] args) {
        Account savings = new SavingsAccount("SAV123", 10000);
        Account checking = new CheckingAccount("CHK456", 3000);
        // Perform operations
        savings.displayBalance();
        savings.deposit(2000);
        savings.withdraw(6000); // exceeds limit
        savings.withdraw(3000);
        savings.displayBalance();

        System.out.println("------------");

        checking.displayBalance();
        checking.deposit(1500);
        checking.withdraw(4000); // allowed with overdraft
        checking.withdraw(5000); // exceeds overdraft
        checking.displayBalance();
    }
}


// Output
Account SAV123 Balance: 10000.0
Deposited 2000.0 into Savings Account.
Withdrawal exceeds limit for Savings Account!
Withdrew 3000.0 from Savings Account.
Account SAV123 Balance: 9000.0
------------
Account CHK456 Balance: 3000.0
Deposited 1500.0 into Checking Account.
Withdrew 4000.0 from Checking Account.
Withdrawal exceeds overdraft limit for Checking Account!
Account CHK456 Balance: 500.0

What OOP Concepts are Used?
// Abstraction → Account is abstract (cannot be created directly).
// Encapsulation → balance is protected/private, accessed via methods.
// Polymorphism → Account savings = new SavingsAccount(...) (same type, different behavior).
// Inheritance → SavingsAccount and CheckingAccount extend Account.
// Interface → Transaction enforces deposit & withdraw methods.
