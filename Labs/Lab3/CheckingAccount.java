public class CheckingAccount extends BankAccount
{
  private int transctCount;
  private static final int FREE_TRANSCT = 3;
  private static final double FEE = 2.0;

  public CheckingAccount(int initialBalance)
  {
    super(initialBalance);
    transctCount = 0;
  }

  public void deposit(double amount)
  {
    transctCount++;
    super.deposit(amount);
  }

  public void withdraw(double amount)
  {
    transctCount++;
    super.withdraw(amount);
  }

  public void deductFees()
  {
    if(transctCount > FREE_TRANSCT)
    {
      double fees = FEE * (transctCount - FREE_TRANSCT);
      super.withdraw(fees);
    }
    transctCount = 0;
  }
}
