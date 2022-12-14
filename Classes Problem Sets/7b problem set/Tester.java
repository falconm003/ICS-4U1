// Falcone, Matthew
// 2022-11-22
// 7b PRoblem Set 3
class Tester {
    public static void main(String[] args) {
      BankAccount myAccount = new BankAccount(1000, "Matthew");
      myAccount.deposit(505.22);
      System.out.println(myAccount.balance);
      myAccount.withdraw(100);
      System.out.println("The Sally Jones account balance is: $" + myAccount.balance);
    }
  }