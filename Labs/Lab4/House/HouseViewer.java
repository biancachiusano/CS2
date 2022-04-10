import javax.swing.JFrame;

public class HouseViewer
{
  /**
   * Main method
   * @param args array of type String
   */
    public static void main(String[] args)
    {
      /**
       * Constructing the frame of the application
       * Setting the frame's size, title, close operation and visibility
       * Adding a House component {@link HouseComponent.java} to the frame
       */
      JFrame frame = new JFrame();
      frame.setSize(400, 400);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setTitle("Drawing a House - Exercise 1");
      HouseComponent houseDraw = new HouseComponent();
      frame.add(houseDraw);
      frame.setVisible(true);
    }
}
