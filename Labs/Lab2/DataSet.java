import java.io.*;
import java.util.*;

/**
 * DataSet Class used ONLY for exercise 1 and 2 of Lab 2
 */
public class DataSet
{
  private double sum;
  private Object maximum;
  private int count;
  private Measurer measurer;
  private Filter filter;

  /**
   * DataSet class Constructor, used in Exercise 1 {@link Person.java}
   * @param aMeasurer Measurer uses measure method implemented in PersonHeight {@link PersonHeight.java}
   */
  public DataSet(Measurer aMeasurer)
  {
    sum = 0;
    count = 0;
    maximum = null;
    measurer = aMeasurer;
  }

  /**
   * DataSet class Constructor, used in Exercise 2 {@link Person.java}
   * @param afilter   Filter uses accept method implemented in AccountFilter {@link AccountFilter.java}
   * @param aMeasurer Measurer uses measure method implemented in AccountFilter {@link AccountFilter.java}
   */
  public DataSet(Filter afilter, Measurer aMeasurer)
  {
    count = 0;
    filter = afilter;
    measurer = aMeasurer;
  }

/*
Exercise 2
 */
/**
 * Adds BankAccounts to the DataSet
 * Only accepts BankAccounts with an initialBalance greater than 1000
 * After filtering, the class measures the maximum balance
 * @param x type BankAccount
 */
  public void addBankAccount(BankAccount x)
  {
    if(filter.accept(x)){
      sum = sum + measurer.measure(x);
      if(count == 0 || measurer.measure(maximum) < measurer.measure(x))
      {
        maximum = x;
      }
      count++;
    }
  }

/*
Exercise 1
 */
/**
 * Adds Objects to the DataSet
 * Measures the maximum height of the Person Object added
 * Keeps track of the amount of objects added to the DataSet
 * @param x type Object (Person in Exercise 1)
 */
  public void add(Object x)
  {
    sum = sum + measurer.measure(x);
    if(count == 0 || measurer.measure(maximum) < measurer.measure(x))
    {
      maximum = x;
    }
    count++;
  }

  public double getAverage()
  {
    if(count == 0)
    {
      return 0;
    }
    else
    {
      return sum/count;
    }
  }

  public Object getMaximum()
  {return maximum;}
}
