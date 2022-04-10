import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Welcome frame that will open when the login button is pushed
 * Note: the window create by this class will contain a button that connects to the window from exercise 1
 * @author biancacaissottidichiusano
 *
 */
public class WelcomeFrame extends JFrame{
	
	private JButton ex1Button;
	private ActionListener listener;
	private JLabel greetingsLabel;
	
	/**
	 * Creates components and sets these on the JFrame 
	 * Components: greeting label and button that connects to Exercise 1
	 * @param name of the user that has logged in from the previous window
	 */
	public WelcomeFrame(String name) {
		
		JPanel welcomePanel = new JPanel();
		welcomePanel.setLayout(new BorderLayout());
		
		greetingsLabel = new JLabel();
		greetingsLabel.setText("You are logged in! Welcome " + name);
		
		ex1Button = new JButton("Go to Exercise 1");
		listener = new ex1ButtonPushed();
		ex1Button.addActionListener(listener);
		
		welcomePanel.add(greetingsLabel, BorderLayout.CENTER);
		welcomePanel.add(ex1Button, BorderLayout.SOUTH);
		add(welcomePanel, BorderLayout.CENTER);
	}
	
	/**
	 * Class listener for the button 
	 * @author biancacaissottidichiusano
	 *
	 */
	public class ex1ButtonPushed implements ActionListener{
		//When button is clicked the window created in exercise 1 will open and this window will be set invisible
		@Override
		public void actionPerformed(ActionEvent e) {
			CurrencyConverter.main(null);
			setVisible(false);
		}
		
	}
	
	/**
	 * Main method 
	 * @param args: contains name of the user that has logged in (type String)
	 * Creates a new JFrame by calling the class constructor which will place all components on top
	 */
	public static void main(String[] args) {
		String name  = args[0];
		JFrame welcomeFrame = new WelcomeFrame(name);
		welcomeFrame.setTitle("Welcome Window");
		welcomeFrame.setSize(260, 150);
		welcomeFrame.setLocationRelativeTo(null);
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		welcomeFrame.setVisible(true);
	}
}
