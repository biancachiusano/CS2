import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;

/**
 * Class that draws the house with all of its components
 */
public class House extends JComponent{
	private double XCoordinate;
	private double YCoordinate;

/**
 * Class Constructor
 * @param x xCoordinate, on the JFrame
 * @param y yCoordiante, on the JFrame
 */
	  public House(double x, double y)
	  {
	    XCoordinate = x;
	    YCoordinate = y;
	  }

/**
 * Initializes and then draws all of the different components of the house
 * This method is called from {@link HouseComponent.java}
 * @param g2 of type Graphics2D
 */
	  public void draw(Graphics2D g2)
	  {
      //Two Rectangles, one for the main body of the house and one for the door
	    Rectangle2D.Double main = new  Rectangle2D.Double(XCoordinate, YCoordinate + 10, 300, 200);
	    Rectangle2D.Double door = new  Rectangle2D.Double(XCoordinate + 130, YCoordinate + 130, 40, 80);
      //Two ellipses for the two windows
      Ellipse2D.Double window1 = new Ellipse2D.Double(XCoordinate + 60, YCoordinate + 50, 60, 60);
	    Ellipse2D.Double window2 = new Ellipse2D.Double(XCoordinate + 180, YCoordinate + 50, 60, 60);
      //Three points to connect the two lines for the roof
      //P1 and P2 are at a x-coordinate distance as wide as the width of the rectangle of the body
      Point2D.Double p1 = new Point2D.Double(XCoordinate, YCoordinate + 10);
	    Point2D.Double p2 = new Point2D.Double(XCoordinate + 300, YCoordinate + 10);
	    Point2D.Double p3 = new Point2D.Double(XCoordinate + 150, YCoordinate - 80);
      //Two lines that "connect" at p3
	    Line2D.Double roof1 = new Line2D.Double(p1, p3);
	    Line2D.Double roof2 = new Line2D.Double(p3, p2);

      //Drawing the graphics 
	    g2.draw(main);
	    g2.draw(door);
	    g2.draw(window1);
	    g2.draw(window2);
	    g2.draw(roof1);
	    g2.draw(roof2);
	  }
}
