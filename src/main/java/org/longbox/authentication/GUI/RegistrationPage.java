package org.longbox.authentication.GUI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Panel;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.ComponentOrientation;
import java.awt.Container;

public class RegistrationPage extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField firstNameField;
	private JTextField lastNameField;
	private JTextField usernameField;
	private JTextField emailAddress;
	private JPasswordField passwordField;
	private JButton signUpButton;
	private JDateChooser dateChooser;
	private JComboBox countryField;
	private JCheckBox TnCCheckbox;
	private JLabel messageLabel;
	private JButton signInButton;
	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new RegistrationPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationPage() {
		initiateRegUI();
	}

	public void initiateRegUI() {
		//initializing the main frame
		setTitle("LongBox - Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 809, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		
		
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		
		

		//Header label
		JLabel HeaderLabel = new JLabel("Sign Up and Start Reading Comics!");
		HeaderLabel.setBounds(275, 34, 259, 16);
		HeaderLabel.setFont(new Font("Bradley Hand", Font.PLAIN, 16));

		//first name label
		JLabel FirstNameLabel = new JLabel("Your first name:");
		FirstNameLabel.setBounds(117, 70, 94, 16);
		FirstNameLabel.setFont(new Font("Bradley Hand", Font.PLAIN, 12));

		firstNameField = new JTextField();
		firstNameField.setBounds(107, 86, 267, 26);
		firstNameField.setColumns(10);

		//last name label
		JLabel LastNameLabel = new JLabel("Your last name:");
		LastNameLabel.setBounds(451, 70, 83, 16);
		LastNameLabel.setFont(new Font("Bradley Hand", Font.PLAIN, 12));

		lastNameField = new JTextField();
		lastNameField.setBounds(445, 86, 260, 26);
		lastNameField.setColumns(10);

		//username label
		JLabel UsernameLabel = new JLabel("Your username:");
		UsernameLabel.setBounds(117, 187, 83, 16);
		UsernameLabel.setFont(new Font("Bradley Hand", Font.PLAIN, 12));

		usernameField = new JTextField();
		usernameField.setBounds(107, 206, 598, 26);
		usernameField.setColumns(10);

		//email label
		JLabel EmailLabel = new JLabel("Your email:");
		EmailLabel.setBounds(117, 244, 61, 16);
		EmailLabel.setFont(new Font("Bradley Hand", Font.PLAIN, 12));

		emailAddress = new JTextField();
		emailAddress.setBounds(107, 260, 598, 26);
		emailAddress.setColumns(10);

		//password label
		JLabel PasswordLabel = new JLabel("Pick a password:");
		PasswordLabel.setBounds(117, 298, 86, 16);
		PasswordLabel.setFont(new Font("Bradley Hand", Font.PLAIN, 12));

		passwordField = new JPasswordField();
		passwordField.setBounds(107, 316, 598, 26);

		//password specification label
		JLabel PwdSpecLabel = new JLabel("Use at least one lowercase letter, one capital letter, one numeral, one special charachter and 8 - 20 characters.");
		PwdSpecLabel.setBounds(117, 354, 588, 13);
		PwdSpecLabel.setFont(new Font("Bradley Hand", Font.PLAIN, 10));

		//date entering
		JLabel DateLabel = new JLabel("Your date of birth:");
		DateLabel.setBounds(117, 124, 94, 16);
		DateLabel.setFont(new Font("Bradley Hand", Font.PLAIN, 12));

		dateChooser = new JDateChooser();
		dateChooser.setBounds(107, 141, 267, 26);

		// choose country
		JLabel CountryLabel = new JLabel("Choose your country:");
		CountryLabel.setBounds(451, 124, 110, 16);
		CountryLabel.setFont(new Font("Bradley Hand", Font.PLAIN, 12));

		countryField = new JComboBox(getAllCountries());
		countryField.setBounds(445, 141, 260, 27);

		//sign up button
		signUpButton = new JButton("Sign Up for LongBox!");
		signUpButton.setBounds(107, 422, 608, 29);
		signUpButton.setFont(new Font("Bradley Hand", Font.PLAIN, 13));
		signUpButton.setEnabled(false);
		signUpButton.setFocusable(false);

		//Terms and Conditions check box
		TnCCheckbox = new JCheckBox("I agree to the terms and conditions of these app.");
		TnCCheckbox.setBounds(107, 387, 598, 23);
		TnCCheckbox.setFont(new Font("Bradley Hand", Font.PLAIN, 12));
		
		// message label to print invalid email and password
		messageLabel = new JLabel("");
		messageLabel.setVerticalTextPosition(SwingConstants.TOP);
		messageLabel.setBounds(117, 370, 588, 16);
		messageLabel.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		messageLabel.setFont(new Font("Bradley Hand", Font.PLAIN, 12));
		
		//sign in label
		JLabel signInLabel = new JLabel("Already a member? Sign In!");
		signInLabel.setFont(new Font("Bradley Hand", Font.PLAIN, 13));
		signInLabel.setBounds(117, 463, 287, 16);
		
		
		//sign up label
		signInButton = new JButton("Sign In!");
		signInButton.setFont(new Font("Bradley Hand", Font.PLAIN, 12));
		signInButton.setBounds(451, 458, 264, 29);
		signInButton.addActionListener(this);
		
		// adding elements to the pane
		contentPane.setLayout(null);
		contentPane.add(HeaderLabel);
		contentPane.add(FirstNameLabel);
		contentPane.add(firstNameField);
		contentPane.add(LastNameLabel);
		contentPane.add(lastNameField);
		contentPane.add(UsernameLabel);
		contentPane.add(usernameField);
		contentPane.add(EmailLabel);
		contentPane.add(emailAddress);
		contentPane.add(PasswordLabel);
		contentPane.add(passwordField);
		contentPane.add(PwdSpecLabel);
		contentPane.add(DateLabel);
		contentPane.add(dateChooser);
		contentPane.add(CountryLabel);
		contentPane.add(countryField);
		contentPane.add(signUpButton);
		contentPane.add(TnCCheckbox);
		contentPane.add(messageLabel);
		contentPane.add(signInLabel);
		contentPane.add(signInButton);

		// action listener
		firstNameField.addActionListener(fieldsListener);
		lastNameField.addActionListener(fieldsListener);
		usernameField.addActionListener(fieldsListener);
		emailAddress.addActionListener(fieldsListener);
		passwordField.addActionListener(fieldsListener);
		countryField.addActionListener(fieldsListener);
		signUpButton.addActionListener(this);
		TnCCheckbox.addActionListener(fieldsListener);

		// focus adapter
		firstNameField.addFocusListener(focusAdapter);
		emailAddress.addFocusListener(focusAdapter);
		passwordField.addFocusListener(focusAdapter);
		dateChooser.addFocusListener(focusAdapter);
		usernameField.addFocusListener(focusAdapter);
		lastNameField.addFocusListener(focusAdapter);


		//Document listener for fields
		firstNameField.getDocument().addDocumentListener(documentListener);
		lastNameField.getDocument().addDocumentListener(documentListener);
		usernameField.getDocument().addDocumentListener(documentListener);
		emailAddress.getDocument().addDocumentListener(documentListener);
		passwordField.getDocument().addDocumentListener(documentListener);

		updateButtonState();
	}

	// used the below code from https://stackoverflow.com/questions/19004303/populate-a-choice-menu-with-all-countries-to-in-java
	@SuppressWarnings("deprecation")
	public String[] getAllCountries() {
		String[] countries = new String[Locale.getISOCountries().length];
		String[] countryCodes = Locale.getISOCountries();
		for (int i = 0; i < countryCodes.length; i++) {
			Locale obj = new Locale("", countryCodes[i]);
			countries[i] = obj.getDisplayCountry();
		}
		return countries;
	}

	ActionListener fieldsListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			updateButtonState();
		}
	};

	FocusAdapter focusAdapter = new FocusAdapter() {
		@Override
		public void focusLost(FocusEvent e) {
			updateButtonState();
		}
	};

	DocumentListener documentListener = new DocumentListener() {
		@Override
		public void insertUpdate(DocumentEvent e) { 	
			updateButtonState();
		}

		@Override
		public void removeUpdate(DocumentEvent e) {
			updateButtonState();
		}

		@Override
		public void changedUpdate(DocumentEvent e) {
			updateButtonState();
		}
	};

	private void updateButtonState() {
		// Enable the button only if all fields are non-empty
		boolean enableButton = !firstNameField.getText().isEmpty() &&
				!lastNameField.getText().isEmpty() &&
				!usernameField.getText().isEmpty() && 
				!emailAddress.getText().isEmpty() &&
				passwordField.getPassword().length > 0 &&
				countryField.getSelectedItem() != null &&
				dateChooser.getDate() != null &&
				isValidEmailAddress(emailAddress.getText()) &&
				isValidPassword(String.valueOf(passwordField.getPassword())) &&
				TnCCheckbox.isSelected();

				// prints the invalid mail and email message
				if(!isValidEmailAddress(emailAddress.getText()) && !isValidPassword(String.valueOf(passwordField.getPassword()))) {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Please enter a valid email and a valid password!");
				}else if(isValidEmailAddress(emailAddress.getText()) && !isValidPassword(String.valueOf(passwordField.getPassword()))){
					messageLabel.setText("Please enter a valid password!");
				}else if(!isValidEmailAddress(emailAddress.getText()) && isValidPassword(String.valueOf(passwordField.getPassword()))) {
					messageLabel.setText("Please enter a valid email!");
				}else {
					messageLabel.setText("");
				}


				//if all the conditions are matched enable the button
				signUpButton.setEnabled(enableButton);
	}

	// validate email stack overflow
	public static boolean isValidEmailAddress(String email) {
		boolean result = true;
		try {
			InternetAddress emailAddr = new InternetAddress(email);
			emailAddr.validate();
		} catch (AddressException ex) {
			result = false;
		}
		return result;
	}

	// validate password https://www.geeksforgeeks.org/how-to-validate-a-password-using-regular-expressions-in-java/
	public static boolean isValidPassword(String password){
		String regex = "^(?=.*[0-9])"
				+ "(?=.*[a-z])(?=.*[A-Z])"
				+ "(?=.*[@#$%^&+=!])"
				+ "(?=\\S+$).{8,20}$";
		Pattern p = Pattern.compile(regex);

		if (password == null) {
			return false;
		}

		Matcher m = p.matcher(password);

		return m.matches();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == signUpButton) {
			String firstName = firstNameField.getText();
			String lastName = lastNameField.getText();
			Date date = dateChooser.getDate();
			String username = usernameField.getText();
			String email = emailAddress.getText();
			String password = String.valueOf(passwordField.getPassword());
			String country = countryField.getSelectedItem().toString(); 

			//formats the date
			SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
			String dob = dcn.format(date);

//			System.out.println(firstName);
//			System.out.println(lastName);
//			System.out.println(dob);
//			System.out.println(username);
//			System.out.println(email);
//			System.out.println(password);
//			System.out.println(country);
			
		}else if(e.getSource() == signInButton) {
			frame.dispose();
			LoginPage loginPage = new LoginPage();
			loginPage.setVisible(true);
		}

	}
}
