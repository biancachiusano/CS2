import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ClickListener class implememts ActionListener interface
 */
public class ClickListener implements ActionListener
{
  /**
   * Private non-static counter that is unique for each button
   */
  private int counter = 0;
/**
 * actionPerformed method contains instructions that have to be extecuted whenever the button is clicked
 * @param event [description]
 */
  public void actionPerformed(ActionEvent event)
  {
      counter++;
      System.out.println("I was clicked: " + counter + " times");
  }
}
