/**
 * AccountFilter Class implements Filter and Measurer Interfaces
 */
public class AccountFilter implements Filter, Measurer
{

  BankAccount b;

  /**
   * checks if the BankAccount object passed has an initialBalance greater than 1000
   * @param  anObject type Object. Note this will be casted as a BankAccount
   * @return          true is the initialBalance is greater than 1000, else false
   */
  public boolean accept(Object anObject)
  {
    b = (BankAccount) anObject;
    double balance = b.getBalance();
    if(balance < 1000)
    {
      return false;
    }
    else {
      return true;
    }
  }

  /**
   * measures the balance of the BankAccount passed
   * @param  anObject type Object. Note this will be casted as a BankAccount
   * @return          balance of the BankAccount
   */
  public double measure(Object anObject)
  {
    b = (BankAccount) anObject;
    double balance = b.getBalance();
    return balance;
  }
}
