import java.io.*;
import java.util.*;
/**
 * Class BankAccount
 * Used to create BankAccount objects
 */
public class BankAccount
{

	private double balance;
	private final double FEE = 0.05; //Fee of 0.05%

	//Variables needed to describe an account and its information
	public static String accountName = "BankAccount";
	public static String transactionType;
	public static String currency = "euros";
	public int accountNumber;
	public double transactionAmount;

	/*
	Initializing the transaction count to 0, assuming the examples in TestBankAccount
	start from the beggining of the month.
	 */
	public int transactionCount = 0;

/**
 * Class Constructor
 * @param initialBalance the account's balance when the account is created
 * @param number         the account's number - Example: BankAccount 1
 */
	public BankAccount(double initialBalance, int number)
	{
		balance = initialBalance;
		accountNumber = number;
	}

	/**
	 * Transaction type - Deposit: placing more money in the desired Bank Account.
	 * TransactionCount increases everytime a transaction is made.
	 * Checks if the amount of transactions made with the BankAccount exceeds the free allotment
	 * if so the transaction is exposed to a charge of 0.05%.
	 * The balance is updated.
	 * Global String is updated.
	 * @param amount amount of money to add to the account's balance
	 */
	public void deposit(double amount)
	{
		transactionCount++;

		if(deductMonthlyCharge(transactionCount))
		{
			amount = amount*(1-FEE);
		}

		double newBalance = balance + amount;

		balance = newBalance;
		transactionType = "Deposit";
		transactionAmount = amount;
	}

	/**
	 * Transaction type - Withdraw: taking money away from the desired Bank Account.
	 * TransactionCount increases everytime a transaction is made.
	 * Checks if the amount of transactions made with the BankAccount exceeds the free allotment
	 * if so the transaction is exposed to a charge of 0.05%.
	 * The balance is updated.
	 * Global String is updated.
	 * @param amount amount of money to take away from the Bank Account
	 */
	public void withdraw(double amount)
	{
		transactionCount++;
		if(deductMonthlyCharge(transactionCount))
		{
			amount = amount*(1+FEE);
		}

		double newBalance = balance - amount;
		balance = newBalance;
		transactionType = "Withdraw";
		transactionAmount = amount;
	}

/**
 * Checks if the amount of transactions made with the BankAccount exceeds the free allotment of 2 free monthly transactions
 * @param  transactionCount the amount of transactions made this month by the account in question
 * @return                  true is the transactions made this month exceeds the free allotment, else false.
 */
	public boolean deductMonthlyCharge(int transactionCount)
	{
		if(transactionCount > 2)
		{
			return true;
		}
		else
			return false;
	}

/**
 * Returns the account's current balance
 * @return amount of money in the account currently
 */
	public double getBalance()
	{
		return balance;
	}

}
