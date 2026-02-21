package encapsulation;

class BankAccount {
    // 1. Private variables: Only this class can touch them directly
    private String owner;
    private double balance;

    // 2. Constructor: Automatically runs when you use 'new'
    // It forces you to set initial values right away.
    public BankAccount(String ownerName, double initialDeposit) {
        this.owner = ownerName; // 'this' refers to the current object
        
        if (initialDeposit > 0) {
            this.balance = initialDeposit;
        } else {
            this.balance = 0;
        }
    }

    // 3. Getter: Safely lets the outside world READ the data
    public double getBalance() {
        return balance;
    }

    // 4. Setter/Mutator: Safely lets the outside world MODIFY the data with rules
    public void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Cannot deposit negative money.");
        }
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        
        // Creating the object using the constructor
        BankAccount myAccount = new BankAccount("Test User", 100.0);

        // myAccount.balance = 50000; // ERROR! balance is private. 

        // We MUST use the methods provided
        System.out.println("Starting Balance: " + myAccount.getBalance());
        
        myAccount.deposit(50.0);
        myAccount.deposit(-20.0); // The class will block this bad data
        
        System.out.println("Final Balance: " + myAccount.getBalance());
    }
}