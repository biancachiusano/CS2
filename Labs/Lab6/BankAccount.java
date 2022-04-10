/**
 * Class BankAccount edited for exercise 3
 * @author biancacaissottidichiusano
 *
 */
public class BankAccount
{  
	/**
	 * Class constructor
	 * @param initialBalance
	 * @throws IllegalArgumentException: if the initial balance of the BankAccount object is negative
	 */
	public BankAccount(double initialBalance) throws IllegalArgumentException
   {  
		if(initialBalance < 0) {
		   	throw new IllegalArgumentException("An account cannot be created with a negative balance!");
	   	}
		balance = initialBalance;
   }
	/**
	 * Method deposit to increase the balance in the BankAccount
	 * @param amount
	 * Throws IllegalArgumentException is the amount deposited is of a negative value
	 */
   public void deposit(double amount)
   {  
	  if(amount < 0) {
		  throw new IllegalArgumentException("You cannot deposit a negative amount!");
	  }
	  double newBalance = balance + amount;
      balance = newBalance;
   }
   /**
    * Withdraw method to retrieve money from the account, decreases the balance
    * @param amount
    * Throws IllegalArgumentException is the amount withdrawn is negative or greater than the current balance
    */
   public void withdraw(double amount)
   {  
	  if(amount < 0 || amount > balance) {
		  throw new IllegalArgumentException("You cannot withdraw a negative amount, or a value greater than your current balance!");
	  }
	  double newBalance = balance - amount;
      balance = newBalance;
   }
   /**
    * 
    * @return the current balance of the account
    */
   public double getBalance()
   { 
	   return balance;
   }
   private double balance;
   
}
