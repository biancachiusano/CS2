import javax.swing.JFrame;

public class OlympicRingViewer {
	/**
	 * Main method
	 * Creates the JFrame which, in turn, adds a new object of type OlympicRingComponent
	 * @param args array of type String
	 */
	public static void main(String[] args)
    {
      /**
       * Constructing the frame of the application
       * Setting the frame's size, title, close operation and visibility
       * Adding an OlympicRingComponent {@link OlympicRingComponent.java} to the frame
       */
      JFrame frame = new JFrame();
      frame.setSize(400, 300);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Drawing Olympic Rings - Exercise 2");

      OlympicRingComponent olympicRings = new OlympicRingComponent();
      frame.add(olympicRings);

      frame.setVisible(true);
    }
}
