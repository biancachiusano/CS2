public class BankAccount
{
  protected double balance;
  /**
   * Class Constructor
   * @param account's initial balance
   */
  public BankAccount(double balance)
  {
    this.balance = balance;
  }

  /**
   * Adds money to the account
   * @param amount of money to add to the account
   */
  public void deposit(double amount)
  {
    balance = balance + amount;
  }

  /**
   * Takes money away from the account
   * @param amount of money to take away from the account
   */
  public void withdraw(double amount)
  {
    balance = balance - amount;
  }

  /**
   * Gets the current balance of the account, i.e amount of money in the account currently
   * @return the amount of money, or the balance
   */
  public double getBalance()
  {
    return balance;
  }
}
