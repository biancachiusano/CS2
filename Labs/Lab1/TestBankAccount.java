import java.io.*;
import java.util.*;

/**
 * Class to test the class BankAccount {@link BankAccount}
 * @author Bianca Caissotti di Chiusano
 */
public class TestBankAccount {

/**
 * Tests the transactions made by 4 different BankAccounts
 * Calls methods "printing" and "startAndEndBalances"
 * @param args an array of Strings
 */
	public static void main(String[] args)
	{

		/*
		Instantiating 4 BankAccount objects that take in the account's
		initial balance, and the account number
		 */
		BankAccount account1 = new BankAccount(500, 1);
		BankAccount account2 = new BankAccount(3000, 2);
		BankAccount account3 = new BankAccount(40, 3);
		BankAccount account4 = new BankAccount(680, 4);


		/*
		Examples  of transactions
		Account 1 makes 3 transactions this month, thus will be exposed to a monthly charge of 0.05%
		 */
		account1.deposit(300);
		printing(account1);
		account1.withdraw(50);
		printing(account1);
		account1.withdraw(60);
		printing(account1);

		account2.withdraw(400);
		printing(account2);

		account3.withdraw(5);
		printing(account3);

		account4.deposit(55);
		printing(account4);

		System.out.println();
		/*
		Prinitng each account's balance at the beginning and end of the month
		 */
		startAndEndBalances(account1, 500);
		startAndEndBalances(account2, 3000);
		startAndEndBalances(account3, 40);
		startAndEndBalances(account4, 680);
	}

	/**
	 * Called every time a transaction is made
	 * prints the accounts: name, number, transaction type, transaction amount, currency
	 * @param account the account object that was used to make a transaction
	 */
	public static void printing(BankAccount account)
	{
		System.out.println(account.accountName + ": " + account.accountNumber + "    " + account.transactionType + ":   " + account.transactionAmount + " " + account.currency);
	}

	/**
	 * Prints an account's balance at the start and end of the month
	 * @param account        the account object that we want to know information of
	 * @param initialBalance the account's initial balance at the start of the month
	 * Resets the Transaction count for the account passed to 0
	 */
	public static void startAndEndBalances(BankAccount account, double initialBalance)
	{
		System.out.println(account.accountName +  " " + account.accountNumber + " - Start of month, initial balance: " + initialBalance + " euros");
		System.out.println(account.accountName + " " + account.accountNumber + " - End of month, current balance, with an additional charge of 0.05% for all transactions exceeding the free allotment(2) : " + account.getBalance() + " euros");
		System.out.println("Resetting transaction count to 0...");
		account.transactionCount = 0;
		System.out.println();
	}
}
