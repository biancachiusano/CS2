import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * Class for exercise 1 of Lab Five: Converts amounts of money from one currency to another
 * @author biancacaissottidichiusano
 *
 */
public class CurrencyConverter extends JFrame{
	
	private JTextField amount;
	private JComboBox<String> start; 
	private JComboBox<String> end; 
	private JButton convert;
	private JLabel result;
	private ActionListener listener;
	
	private final static int WIDTH = 400;
	private final static int HEIGHT = 250;
	
	/**
	 * Creating components
	 * TextField: the user can place any amount
	 * ComboBoxes: two comboBoxes (start and end) 
	 * Button: button convert 
	 * Label: displays the converted amount with its currency, or a message
	 */
	public CurrencyConverter() {
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3,1));
		
		
		amount = new JTextField();
		amount.setBorder(new TitledBorder(new EtchedBorder(), "Amount of Money"));
		amount.setSize(100, 20);
		mainPanel.add(amount);
		
		listener = new ComboBoxListener();
		
		JPanel comboPanels = createComboPanel();
		comboPanels.setBorder(new TitledBorder(new EtchedBorder(), "Choose Currencies"));
		
		JPanel buttonPanel = createButtonPanel();
		mainPanel.add(comboPanels);
		mainPanel.add(buttonPanel);
	
		add(mainPanel, BorderLayout.CENTER);
		
		setTitle("Lab Five - Exercise 1");
		setSize(WIDTH, HEIGHT);
	}
	
	/**
	 * Initializes two ComboBoxes with the same three currencies 
	 * @return JPanel with two comboBoxes
	 */
	public JPanel createComboPanel() {
		
		JPanel panel = new JPanel();
		
		start = new JComboBox<String>();
		start.setBorder(new TitledBorder(new EtchedBorder(), "From"));
		start.addItem("EUR");
		start.addItem("USD");
		start.addItem("GBP");
		start.setSize(50, 20);
		
		end = new JComboBox<String>();
		end.setBorder(new TitledBorder(new EtchedBorder(), "To"));
		end.addItem("EUR");
		end.addItem("USD");
		end.addItem("GBP");
		end.setSize(50, 20);
		
		panel.add(start);
		panel.add(end);
		
		return panel;
	}
	
	/**
	 * Convert button has an ActionListener that is called when the button is pushed
	 * @return JPanel with convert button
	 */
	public JPanel createButtonPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1));
		
		convert = new JButton("Convert!");
		convert.addActionListener(listener);
		
		result = new JLabel("Status");
		result.setSize(100, 30);
		
		panel.add(convert);
		panel.add(result);
		
		return panel;
	}
	
	public class ComboBoxListener implements ActionListener{
		/**
		 * When button is pushed the amount inputed in the text field and the choices from the comboBoxes 
		 * are considered and the correct commends from the corresponding if statements will be performed 
		 * If no amount is inputed in the textField or if the currencies selected are the same, a message will be displayed
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			String startCurrency = (String) start.getSelectedItem();
			String endCurrency = (String) end.getSelectedItem();
			
			if(amount.getText().toString().isEmpty()) {
				result.setText("No amount inputted");
			} else {
				double input = Double.valueOf(amount.getText());
				String calculate;
				
				/*if(startCurrency.equals(null) || endCurrency.equals(null)) {
					result.setText("Make sure two currencies have been selected");
				}*/
				if(startCurrency.equals(endCurrency)) {
					result.setText("Make sure two currencies have been selected");
				}
				
				//Euro to Dollars
				else if(startCurrency.equals("EUR") && endCurrency.equals("USD")) {
					calculate = String.valueOf(input * 1.18);
					result.setText(calculate + " Dollars");
				}
				//Euro to Pounds
				else if(startCurrency.equals("EUR") && endCurrency.equals("GBP")) {
					calculate = String.valueOf(input/1.12);
					result.setText(calculate + " British Pounds");
				}
				//Dollars to Euro
				else if(startCurrency.equals("USD") && endCurrency.equals("EUR")) {
					calculate = String.valueOf(input/1.18);
					result.setText(calculate + " Euro");
				}
				//Dollars to Pounds
				else if(startCurrency.equals("USD") && endCurrency.equals("GBP")) {
					calculate = String.valueOf(input/1.32);
					result.setText(calculate + " British Pounds");
				}
				//Pounds to Euro
				else if(startCurrency.equals("GBP") && endCurrency.equals("EUR")) {
					calculate = String.valueOf(input * 1.12);
					result.setText(calculate + " Euros");
				}
				//Pounds to Dollars
				else if(startCurrency.equals("GBP") && endCurrency.equals("USD")) {
					calculate = String.valueOf(input * 1.32);
					result.setText(calculate + " Dollars");
				}
			}
		}
	}
	
	/**
	 * Main Method
	 * Initializes a new JFrame by calling the class's constructor that will add components 
	 * @param args will be null
	 */
	public static void main(String[] args) {
		JFrame frame = new CurrencyConverter();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
