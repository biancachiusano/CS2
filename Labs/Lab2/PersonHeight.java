/**
 * Class implements the interface Measurer
 */
public class PersonHeight implements Measurer
{
  /**
   * Gets the height of the Person passed
   * @param  anObject any Object. Note that this will be casted to type Person
   * @return          height
   */
  public double measure(Object anObject)
  {
    Person p = (Person) anObject;
    double height = p.getHeight();
    return height;
  }
}
