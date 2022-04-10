import java.io.*;
import java.util.*;

public class Person
{

  public  String name;
  public int height;

  /**
   * Call Constructor
   * @param n name of the person
   * @param h height of the person
   */
  public Person(String n, int h)
  {
    name = n;
    height = h;
  }

  /**
   * returns the height of a person
   * @return height
   */
  public double getHeight()
  {
    return height;
  }


  public static void main(String[] args)
  {
    /*
    Exercise 1 - Creates new Person Objects
     */
    Person person1 = new Person("Person1", 180);
    Person person2 = new Person("Person2", 90);
    Person person3 = new Person("Person3", 200);


    Measurer m = new PersonHeight();

    DataSet personDataSet = new DataSet(m);
    personDataSet.add(person1);
    personDataSet.add(person2);
    personDataSet.add(person3);

    Person tallestPerson = (Person) personDataSet.getMaximum();

    System.out.println("Exercise 1: average height and tallest person");
    System.out.println("Average Height: " + personDataSet.getAverage());
    System.out.println("Tallest person: " + tallestPerson.name);
    System.out.println();

    /*
    Exercise 2 - Creates new BankAccount Objects
     */
    BankAccount account1 = new BankAccount(1000, 1);
    BankAccount account2 = new BankAccount(90, 2);
    BankAccount account3 = new BankAccount(800, 3);
    BankAccount account4 = new BankAccount(2500, 4);

    Filter f = new AccountFilter();
    Measurer fm = new AccountFilter();
    DataSet bankAccountsDataSet = new DataSet(f, fm);
    bankAccountsDataSet.addBankAccount(account1);
    bankAccountsDataSet.addBankAccount(account2);
    bankAccountsDataSet.addBankAccount(account3);
    bankAccountsDataSet.addBankAccount(account4);

    BankAccount greatestBalance = (BankAccount) bankAccountsDataSet.getMaximum();

    System.out.println("Exercise 2: Filter out all accounts with less then 1000");
    System.out.println("Account with the greatest balance: " + greatestBalance.accountName + " " + greatestBalance.accountNumber);
    System.out.println("Average of all balances: " + bankAccountsDataSet.getAverage());

  }

}
