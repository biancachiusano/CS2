import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * Exercise 2 for lab 5
 * @author biancacaissottidichiusano
 * Extends JFrame
 */
public class LoginSignUp extends JFrame{

	private JLabel status;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton signUpButton;
	private JButton loginButton;
	private ActionListener loginListener;
	private ActionListener signUpListener;
	private int incorrectCounter = 0;
	
	//Two arraylists that will serve for the sign up
	protected ArrayList<String> usernameArray = new ArrayList<String>();
	protected ArrayList<String> passwordArray = new ArrayList<String>();
	/*Two arrays that will contain the users that have already signed up
	 * and their corresponding passwords
	 */
	protected String[] userArray;
	protected String[] passArray;
	
	/**
	 * Creates components for the JFrame
	 * Status Panel: Contains status label on the north and mainPanel in the center
	 * Main Panel: Contains all other components in the center, i.e: usernameField, passowordFiled and butttons
	 * Login and Sign up button: both have methods that create them, and action listeners
	 */
	public LoginSignUp() {
		
		JPanel statusPanel = new JPanel();
		statusPanel.setLayout(new BorderLayout());
		
		//Label
		status = new JLabel("Status");
		statusPanel.add(status, BorderLayout.NORTH);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		
		//TextFields
		usernameField = new JTextField();
		usernameField.setEditable(true);;
		usernameField.setBorder(new TitledBorder(new EtchedBorder(), "Username"));
		mainPanel.add(usernameField);
		
		//PasswordField
		passwordField = new JPasswordField();
		passwordField.setEditable(true);;
		passwordField.setBorder(new TitledBorder(new EtchedBorder(), "Password"));
		mainPanel.add(passwordField);

		loginListener = new loginListenerClass();
		signUpListener = new signUpListenerClass();

		JPanel buttonPanel = buttonPanelMethod();
		mainPanel.add(buttonPanel);
		
		statusPanel.add(mainPanel, BorderLayout.CENTER);
		add(statusPanel, BorderLayout.CENTER);
	}
	/**
	 * This method is called from LoginSignUp()
	 * Initialized Login and Sign up button, adding a listener to them
	 * @return JPanel containing login and sign-up buttons
	 */
	public JPanel buttonPanelMethod() {
		JPanel panel = new JPanel();
		signUpButton = new JButton("Sign Up");
		signUpButton.setSize(10, 10);
		signUpButton.setEnabled(false);
		signUpButton.addActionListener(signUpListener);

		loginButton = new JButton("Login");
		loginButton.setSize(10, 10);
		loginButton.addActionListener(loginListener);

		panel.add(signUpButton);
		panel.add(loginButton);

		return panel;
	}
	
	/**
	 * Class LoginListener which extends to the signUpListener and implements ActionListener
	 * Listener for the login button
	 * @author biancacaissottidichiusano
	 *
	 */
	public class loginListenerClass extends signUpListenerClass implements ActionListener{
		
		/**
		 * Overriding method actionPerformed from ActionListener interface
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			/*The information in this array will be the information of the
			 * person who logs in. Array will be passed to the main method of WelcomeFrame.java when the login button is pushed
			 * If and only if the user has already signed in
			 */
			String[] personInfo = new String[2];
			
		
			/*LOGIN - when login button is pushed
			 * First check if both fields are NOT empty
			 */
			if(!(usernameField.getText()).isEmpty() && !(passwordField.getText()).isEmpty()) {
				//First check is the username and the password inputted exist and correspond to eachother
				try{
					if(checkIfUsernameAndPasswordExists()) {
					status.setText("Welcome");
					personInfo[0] = usernameField.getText();
					personInfo[1] = passwordField.getText();
					//Opening new window, the welcome frame that will display the username of the user that has logged in
					WelcomeFrame.main(personInfo);
					//Closing the window
					setVisible(false);
					
					}
					else if(onlyUsernameExists()) {
					//User exists but password is wrong
					status.setText("Incorrect Password or username is unavailable");
					
					/*if the user inputs the wrong password for a username (which has been logged in) more then 
					 * 3 times, the program will close
					 */
					incorrectCounter++;
					
						if(incorrectCounter > 3) {
						System.exit(0);
						}
					}
				}catch(NullPointerException event){
					//User has never logged in before
					//SinUp button enables
					status.setText("You are a new user, sign up");
					signUpButton.setEnabled(true);
				}
			}else {
				//If any of the two fields are empty the status label will display this message
				status.setText("Make sure to fill in both text fields");
			}
			
		}
		/**
		 * The array which contains the username and password of all of the users whom have signed up
		 * is userArray. This is done thanks to the existence of the ArrayList usernameArray (see signUpListenerClass)
		 * Note: username is not case sensitive while password is
		 * @return true if the username and password exist in the array and correspond to eachother
		 */
		public boolean checkIfUsernameAndPasswordExists() {
			
			for(int i = 0; i < userArray.length; i++) {
				if((usernameField.getText()).equalsIgnoreCase(userArray[i])) {
					if((passwordField.getText()).equals(passArray[i])) {
						return true;
					}
				}
			}
			return false;
		}

		/**
		 * If the username exists in the array (userArray)
		 * The password must be incorrect, if not this method wouldn't have been called
		 * @return true is the username exists in the array
		 */
		public boolean onlyUsernameExists() {
			
			for(int i = 0; i < userArray.length; i++) {
				if((usernameField.getText()).equalsIgnoreCase(userArray[i])) {
					return true;
				}
			}
			
			return false;
		}
	}

	/**
	 * Listener for the Sign Up button
	 * @author biancacaissottidichiusano
	 *
	 */
	public class signUpListenerClass implements ActionListener{

		/**
		 * Overrides the actionPerformed method from the actionListener interface
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			//Check if both fields have been filled in
			/**
			 * Every time the sign up button is clicked, the new username and password are 
			 * added to the two arraylists. All of the elements of these arraylists are then passed into the 
			 * username and password arrays that will be checked by the login 
			 * Note: when the program is closed, the information in the arraylists will be deleted/lost
			 */
			if(!(usernameField.getText()).isEmpty() && !(passwordField.getText()).isEmpty()) {

				usernameArray.add(usernameField.getText());
				passwordArray.add(passwordField.getText());
				
				userArray = new String[usernameArray.size()];
				passArray = new String[passwordArray.size()];
				
				for(int i = 0; i < usernameArray.size(); i++) {
					userArray[i] = usernameArray.get(i);
					passArray[i] = passwordArray.get(i);
				}
				
				status.setText("Cool, Now you can Login");
			}else {
				status.setText("Make sure to fill both textfields");
			}
		}

	}


	/**
	 * Main class 
	 * Initializes the JFrame (the window) for the login 
	 * Calls LoginSignUp to create the window with its components 
	 * Sets Location relative to null, so that the window get sets at the center of the screen
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame loginFrame = new LoginSignUp();
		loginFrame.setTitle("Login Page - Exercise 2");
		loginFrame.setSize(350, 150);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		loginFrame.setVisible(true);
	}
}