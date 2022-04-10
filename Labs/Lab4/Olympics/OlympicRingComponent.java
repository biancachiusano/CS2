import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.BasicStroke;
import java.awt.geom.Ellipse2D;


public class OlympicRingComponent extends JComponent{
	/**
	 * Ovverride the method paintComponent from JComponent class
	 * @param g of type Graphics
	 */
	 public void paintComponent(Graphics g)
	  {
			/**
			 * Initializing a constant variable (SPACE_CONSTANT) that spaces out the rings by the same amount on the x-axis
			 * this is 67 because 60 is the diameter of the ring, plus keeping in mind the 6.0f of the stroke width
			 * and the space between each ring to prevent overlapping.
			 */
			final int SPACE_CONSTANT = 67;

			/**
			 * Stroke around the circumference of the rings
			 */
	    	Graphics2D g2 = (Graphics2D)g;
			final BasicStroke stroke = new BasicStroke(6.0f);
			g2.setStroke(stroke);

			/**
			 * Initializing one Ellipse ring. This can be drawn several times by calling the method draw()
			 * To move the ring to the desired coordinates, call the method translate()
			 * I also set the colour calling the method setColor()
			 * @param 100 x-coordinate on the JFrame
			 * @param 100 y-coordiante of the JFrame
			 * @param 60  width - dimensions of the circle
			 * @param 60  height - dimensions of the circle
			 */
			Ellipse2D.Double ring = new Ellipse2D.Double(100, 100, 60, 60);
			//blueRing
			g2.setColor(Color.BLUE);
			g2.draw(ring);
			//blackRing
			g2.translate(SPACE_CONSTANT,0);
			g2.setColor(Color.BLACK);
			g2.draw(ring);
			//redRing
			g2.translate(SPACE_CONSTANT,0);
			g2.setColor(Color.RED);
			g2.draw(ring);
			//yellowRing
			g2.translate(-(SPACE_CONSTANT + (SPACE_CONSTANT/2)),30);
			g2.setColor(Color.YELLOW);
			g2.draw(ring);
			//greenRing
			g2.translate(SPACE_CONSTANT,0);
			g2.setColor(Color.GREEN);
			g2.draw(ring);
	  }
}
