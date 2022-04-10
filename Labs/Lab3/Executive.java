public class Executive extends Manager {

  /**
   * Class Constructor
   * @param n Executive's name
   * @param s Executive's salary
   * @param d Executive's department
   * This class inherits Manager, thus also Employee's methods, it has the exact same constructor
   */
  public Executive(String n, double s, String d)
  {
    super(n, s, d);
  }

  /**
   * @return String with executive's name, salary and department
   */
  public String toString()
  {
    String str = "Executive's name: " + super.getName() + ", Salary: " + super.getSalary() + ", Department: " + this.getDepartment();
    return str;
  }
}
