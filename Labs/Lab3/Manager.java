public class Manager extends Employee {

  protected String department;

  /**
   * Class Constructor
   * @param n name of the manager
   * @param s salary of the manager
   * @param d department where the manager works
   * This class inherits Employee class. Uses employee's constructor and methods
   */
  public Manager(String n, double s, String d)
  {
    super(n, s);
    this.department = d;
  }

  /**
   * @return department where the manager works, in type String
   */
  public String getDepartment()
  {
    return department;
  }

  /**
   * For this exercise we have to create String methods for all three classes
   * @return String with manager's name, salary and department
   */
  public String toString()
  {
    String str = "Manager's name: " + super.getName() + ", Salary: " + super.getSalary() + ", Department: " + this.getDepartment();
    return str;
  }
}
