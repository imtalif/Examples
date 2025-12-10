class BankAccount{
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance){
        this.accountNumber = accountNumber;
        this.balance = balance; 
    }
    void deposit(double amount){
        balance += amount;
        System.out.println("The Deposited amount is "+ amount);
    }
    void withdraw(double amount){
        if(amount > balance){
            System.out.println("Insufficient balance");
        }else{
        balance -= amount;
        System.out.println("The Withdrawn amount is " + amount +" the new balance :" + balance); 
    }
}
    void displayBalance(){
        System.out.println("Account" + accountNumber + "The balance is " + balance);
    }
}
class SavingsAccount extends BankAccount{
    double interestRate;
    SavingsAccount(String accountNumber,double balance,double interestRate){
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
void applyinterest(){
    double interest = balance * interestRate/100;
    balance += interest;
    System.out.println("Interest applied: " + interest + ". New balance: " + balance); 
}

}
class CurrentAccount extends BankAccount{
    double overdraftLimit;
    CurrentAccount(String accountNumber, double balance, double overdraftLimit){
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }
    void withdraw(double amount){
        if(balance - amount < overdraftLimit){
            System.out.println("Exceeding overdraftLimt");
        }else{
            balance -= amount;
            System.out.println(amount + "withdrawn. New balance :" + balance);
        }
    }
}
public class Bank {
    public static void main(String[] args) {
        SavingsAccount SA1 = new SavingsAccount("SA123", 500000, 6);
        CurrentAccount CA1 = new CurrentAccount("CA123", 7000, -10000);
        System.out.println("//Saving Account Operation");
        SA1.deposit(100000);
        SA1.withdraw(50000);
        SA1.applyinterest();
        SA1.displayBalance();

        System.out.println("//Current Account Operation");
        CA1.deposit(2000);
        CA1.withdraw(4000);
        CA1.withdraw(15000);
        CA1.withdraw(1000);
        CA1.displayBalance();
    }
}
    

