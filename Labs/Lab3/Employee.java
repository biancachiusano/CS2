public class Employee {

  protected String name;
  protected double salary;

  /**
   * Class Constructor
   * @param n name of the employee, of type String
   * @param s salary of the employee, of type double
   */
  public Employee(String n, double s)
  {
    this.name = n;
    this.salary = s;
  }

  /**
   * @return name of the employee
   */
  public String getName()
  {
    return name;
  }

/**
 * @return salary of the employee
 */
  public double getSalary()
  {
    return salary;
  }

/**
 * @return String with name and salary of the employee
 */
  public String toString()
  {
    String str = "Employee's name: " + this.getName() + ", Salary: " + this.getSalary();
    return str;
  }
}
