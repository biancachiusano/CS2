public class TimeDepositAccount extends SavingsAccount

  /*
  Class TimeDeposit Account inherits BankAccount
   */
{
  //private double interestRate;
  private int count;
  private final double FEE = 0.05;

  /*
  Person promises to leave the money in the account for 4 months
   */
  /**
   * Class Constructor
   * Account owner is "promising" to leave the money in the account for at least 4 months
   * Therefore the user should not withdraw before the 4 months have passed
   * @param rate    Interest rate to add at the end of each month
   * @param months  Amount of months that the user has to wait before being able to withdraw money without getting a penalty
   * @param account BankAccount's initial balance
   */
  public TimeDepositAccount(double rate, int months, double account)
  {
    super(rate, account);
    count = months;
  }


/**
 * When this method is called in the TestClass, it means that a month has passed
 * I am overriding this method from savingsAccount class
 * After each month, an interest amount is added to the bankaccount and the amount of months to wait decrements
 */
  public void addInterest()
  {
    count--;
    super.addInterest();
  }

/**
 * Override withdraw method from BankAccount to include an if statement
 * If the account owner withdraws money from the account before 4 months have passed, the the user will lose 0.05% of its balance
 * but still get to withdraw. Else if the 4 months have already passed the normal withdraw method in BankAccount will be executed.
 * @param amount amount of money to withdraw
 */
  public void withdraw(double amount)
  {
    if(count > 0){
      double penalty = getBalance() * FEE;
      balance = balance - (amount + penalty);
    }
    else {
      super.withdraw(amount);
    }
  }
}
