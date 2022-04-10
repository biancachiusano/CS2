import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class ButtonViewer
{
  private static final int FRAME_WIDTH = 400;
  private static final int FRAME_HEIGHT = 200;

/**
 * Main method
 * Creates a frame with a size, close operation, title and visibility
 * The frame adds a panel which, in turn contains a label and two buttons
 * @param args [description]
 */
  public static void main(String[] args)
  {
    //Initializing JFrame, JButton, JLabel and Jpanel
    JFrame frame = new JFrame();
    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    JLabel label = new JLabel("Click one of the two buttons");
    JPanel panel = new JPanel();

    //Adding the two buttons and label to the panel
    panel.add(label);
    panel.add(button1);
    panel.add(button2);
    //Adding the panel to the frame
    frame.add(panel);

    /**
     * Constructing two objects of ActionListener and adding them to the buttons
     */
    ActionListener listener1 = new ClickListener();
    button1.addActionListener(listener1);
    ActionListener listener2 = new ClickListener();
    button2.addActionListener(listener2);

    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    frame.setTitle("Button - Exercise 3");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
