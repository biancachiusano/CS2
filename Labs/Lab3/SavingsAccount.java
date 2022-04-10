public class SavingsAccount extends BankAccount
{
  private double interestRate;

  public SavingsAccount(double rate, double account)
  {
    super(account);
    interestRate = rate;
  }

  public void addInterest()
  {
    double interest = getBalance() * interestRate / 100;
    deposit(interest);
  }
}
