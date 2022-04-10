import java.util.*;
import java.io.*;

public class TestClass
{
  /*
  This class has the main method in which exercises 1, 2 and 3 of lab 3 are tested
   */
  public static void main(String[] args)
  {
    //TIME DEPOSIT TEST - EXERCISE 1
    System.out.println("Exercise 1: ");
    System.out.println();
    TimeDepositAccount account = new TimeDepositAccount(5, 4, 500);
    System.out.println("1. Account created with a balance of 500");
    System.out.println("Initial Balance: " + account.getBalance());
    //User withdrawls with penalty
    System.out.println("2. Account owner withdraws 50, not waiting 4 months: 50 plus penalty will be withdrawn from the account");
    account.withdraw(50);
    System.out.println("Balance with penalty: " + account.getBalance());
    //Depositing back the money:
    System.out.println("3. Depositing back 50 ");
    account.deposit(50);
    System.out.println("Balance (note the account underwent a penalty from the previous withdrawl): " + account.getBalance());

    //4 months have passed
    System.out.println("4. Four months are passing, interest rate has been added ");
    account.addInterest();
    account.addInterest();
    account.addInterest();
    account.addInterest();
    //Now user can withdraw without penalty
    System.out.println("5. Account owner withdraws 25, without penalty ");
    account.withdraw(25);
    System.out.println("Balance: " + account.getBalance());
    System.out.println();


    //SQUARE AND RECTANGLE - EXERCISE 2
    System.out.println("Exercise 2: ");
    System.out.println();
    //Scanner, user input
    System.out.println("Enter side length of the square");
    Scanner scan1 = new Scanner(System.in);
    //Side length of the square
    System.out.print("Side Length: ");
    int s = scan1.nextInt();
    System.out.println();
    //Coordinates of the center of the square
    System.out.println("Enter coordinates of the center: ");
    int c1 = scan1.nextInt();
    int c2 = scan1.nextInt();
    Square square = new Square(c1, c2, s, s);

    System.out.println("The Square: " + square.toString());
    System.out.println("Area of the Square: " + square.getArea());
    System.out.println();


    //EMPLOYEE AND MANAGER - EXERCISE 3
    System.out.println("Exercise 3: ");
    System.out.println();
    //Normal Employee
    Employee normalEmp = new Employee("Normal Employee", 150.5);
    System.out.println(normalEmp.toString());
    //Manager Employee
    Manager managerEmp = new Manager("Manager", 200.3, "Human Resources");
    System.out.println(managerEmp.toString());
    //Executive Employee
    Executive executiveEmp = new Executive("Executive", 1000, "Accounting");
    System.out.println(executiveEmp.toString());
  }
}
