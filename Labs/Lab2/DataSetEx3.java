import java.io.*;
import java.util.*;

/**
 * Generic Class DataSetEx3. DataSet used ONLY for exercise 3
 * Contains Main Method to test for exercise 3
 * Extends Comparable<E>
 */
public class DataSetEx3<E extends Comparable<E>>
{

  private E maximum;
  private E minimum;

  private int count = 0;

  /**
   * gets Maximum
   * @return maximum value
   */
  public E getMaximum()
  {return maximum;}

/**
 * gets Minimum
 * @return minimum value
 */
  public E getMinimum()
  {return minimum;}


/**
 * Adds objects of the same type to the DataSet (Objects and DataSet are of the same type E)
 * Uses the Comparable interface (method compareTo()) to compare two objects, this method returns:
 * negative integer: if the object passed is less than the specified object
 * positive integer: if the object passed is greater than the specified object
 * 0: if the object passed is equal to the specified object
 * Keeps track of the minimum and maximum of the objects passed
 * @param objects type E
 */
  public void add(E objects)
  {
    if(count == 0 || objects.compareTo(minimum) < 0)
    {
      minimum = objects;
    }

    if(count == 0 || objects.compareTo(maximum) > 0)
    {
      maximum = objects;
    }
    count ++;
  }

//TESTING FOR EXERCISE 3
  public static void main(String[] args)
  {
    //Strings
    System.out.println("Testing DataSet (exercise 3) with String objects");
    String stringObject1 = "hello";
    String stringObject2 = "how";
    String stringObject3 = "are";
    String stringObject4 = "you";
    String stringObject5 = "doing";

    DataSetEx3<String> stringDataSet = new DataSetEx3<String>();
    stringDataSet.add(stringObject1);
    stringDataSet.add(stringObject2);
    stringDataSet.add(stringObject3);
    stringDataSet.add(stringObject4);
    stringDataSet.add(stringObject5);

    System.out.println("Maximum String: " + stringDataSet.getMaximum());
    System.out.println("Minimum String: " + stringDataSet.getMinimum());

    //Boolean
    System.out.println("Testing DataSet (exercise 3) with Boolean objects");
    Boolean booleanObject1 = true;
    Boolean booleanObject2 = false;

    DataSetEx3<Boolean> booleanDataSet = new DataSetEx3<Boolean>();
    booleanDataSet.add(booleanObject1);
    booleanDataSet.add(booleanObject2);

    System.out.println("Maximum Boolean: " + booleanDataSet.getMaximum());
    System.out.println("Minimum Boolean: " + booleanDataSet.getMinimum());

    //Double
    System.out.println("Testing DataSet (exercise 3) with Double objects");
    Double doubleObject1 = 3.2;
    Double doubleObject2 = 5.0;
    Double doubleObject3 = 1.0;

    DataSetEx3<Double> doubleDataSet = new DataSetEx3<Double>();
    doubleDataSet.add(doubleObject1);
    doubleDataSet.add(doubleObject2);
    doubleDataSet.add(doubleObject3);

    System.out.println("Maximum Boolean: " + doubleDataSet.getMaximum());
    System.out.println("Minimum Boolean: " + doubleDataSet.getMinimum());

    //Integers
    System.out.println("Testing DataSet (exercise 3) with Integer objects");
    Integer intObject1 = 50;
    Integer intObject2 = -3;
    Integer intObject3 = 2;

    DataSetEx3<Integer> intDataSet = new DataSetEx3<Integer>();
    intDataSet.add(intObject1);
    intDataSet.add(intObject2);
    intDataSet.add(intObject3);

    System.out.println("Maximum Boolean: " + intDataSet.getMaximum());
    System.out.println("Minimum Boolean: " + intDataSet.getMinimum());
  }
}
