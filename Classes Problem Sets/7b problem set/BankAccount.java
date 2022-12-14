public class BankAccount {
    // declare state variables
    public double balance;
    public String name;
    // constructor
    public BankAccount(double b, String n) {
      balance = b;
      name = n;
    }
    // methods
    public void deposit(double b) {
      balance += b;
    }
    public void withdraw(double w) {
      balance -= w;
    }
    
    
  }