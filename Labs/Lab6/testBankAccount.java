/**
 * Test class for exercise 3 of lab 6
 * @author biancacaissottidichiusano
 *
 */
public class testBankAccount{
	
	/**
	 * Main method that causes three IllegalArgumentException to occur
	 * @param args: array of type String
	 * Handling the exceptions with try and catch clauses
	 */
	public static void main(String[] args) {
		try {
			//Creating an account with a negative initial balance 
		   BankAccount negBalanceAccount = new BankAccount(-200);
		}catch(IllegalArgumentException e){
			System.out.println(e);
		}
		
		try {
			//Depositing a negative amount
		   BankAccount negDepositAccount = new BankAccount(200);
		   negDepositAccount.deposit(-300);
		}catch(IllegalArgumentException e) {
			System.out.println(e);
		}
		
		try {
		   //Withdrawing an amount greater than the current balance 
		   BankAccount negWithdrawAccount = new BankAccount(200);
		   negWithdrawAccount.withdraw(250);
		}catch(IllegalArgumentException e) {
			System.out.println(e);
		}
	}
}
