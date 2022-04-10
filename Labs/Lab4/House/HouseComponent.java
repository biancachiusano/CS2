import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * Class that ovverride the method paintComponent to create
 * a complete house in a specific location on the frame.
 * JComponent is a java class for swing components
 */
public class HouseComponent extends JComponent
{
  /**
   * Creates a house of type House {@link House.java} with x and y coordinates on the JFrame
   * Calls the method draw, to draw the graphics of the house. 
   * @param g of type Graphics
   */
  public void paintComponent(Graphics g)
  {

    //New Graphics2D object
    Graphics2D g2 = (Graphics2D)g;
    //New House object
    House house = new House(50, 100);
    //Draw the House
    house.draw(g2);
  }
}
