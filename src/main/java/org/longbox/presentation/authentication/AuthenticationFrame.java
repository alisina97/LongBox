package org.longbox.presentation.authentication;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import lombok.Getter;
import lombok.Setter;
import org.longbox.businesslogic.UserSession;
import org.longbox.businesslogic.exception.UserNameDoesNotExistException;
import org.longbox.businesslogic.exception.UsernameOrEmailExistsException;
import org.longbox.domainobjects.dto.UserDTO;
import org.longbox.persistence.dao.UserDaoImpl;
import org.longbox.persistence.entity.User;
import org.longbox.presentation.profile.HomeFrame;
@Getter
@Setter
public class AuthenticationFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel cardPanel;
	private CardLayout cardLayout;
    private LoginPanel loginPanel = new LoginPanel();
    private RegistrationPanel registrationPanel = new RegistrationPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthenticationFrame frame = new AuthenticationFrame();
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
	public AuthenticationFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 550);
        setTitle("LongBox");
        
        setLocationRelativeTo(null);
        
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        cardPanel.add(loginPanel, "login");
        cardPanel.add(registrationPanel, "registration");

        // Set the default panel to login page
        cardLayout.show(cardPanel, "login");

        add(cardPanel);
        setVisible(true);
        
        // login page buttons action listener
        loginPanel.getSignUpButton().addActionListener(this);
        loginPanel.getSignInButton().addActionListener(this);
        
        //registration page buttons action listener
        registrationPanel.getSignInButton().addActionListener(this);
		registrationPanel.getSignUpButton().addActionListener(this);
		
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginPanel.getSignUpButton()) {
            cardLayout.show(cardPanel, "registration");
        }else if(e.getSource() ==  registrationPanel.getSignInButton()) {
        	cardLayout.show(cardPanel, "login");
        }else if(e.getSource() == loginPanel.getSignInButton()) {
			validateLogin();
        }else if(e.getSource() == registrationPanel.getSignUpButton()) {
			registerUser();
        }
    }

	private void validateLogin(){
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		String UserName = loginPanel.getUsername();
		String DecryptPassword = loginPanel.getDecryptedPassword();

		User user;
		try{
			if (UserName.contains(Character.toString('@'))) {
				user = userDaoImpl.getUserByEmail(UserName);
				if(UserName.equals(user.getEmail())){
					if(DecryptPassword.equals(user.getPassword())){
						loginPanel.getErrorLabel().setText("Login Successful!");
						loginPanel.getErrorLabel().setForeground(Color.GREEN);
						dispose();
						HomeFrame homeFrame = new HomeFrame(UserSession.getInstance(new UserDTO(user)));
						homeFrame.setVisible(true);
					} else {
						loginPanel.getErrorLabel().setText("Password Incorrect");
						loginPanel.getErrorLabel().setForeground(Color.red);
					}
				}
			} else {
				user = userDaoImpl.getUserByUserName(UserName);
				if(UserName.equals(user.getUserName())){
					if(DecryptPassword.equals(user.getPassword())){
						loginPanel.getErrorLabel().setText("Login Successful!");
						loginPanel.getErrorLabel().setForeground(Color.GREEN);
						dispose();
						HomeFrame homeFrame = new HomeFrame(UserSession.getInstance(new UserDTO(user)));
						homeFrame.setVisible(true);
					} else {
						loginPanel.getErrorLabel().setText("Password Incorrect");
						loginPanel.getErrorLabel().setForeground(Color.red);
					}
				}
			}
		} catch (UserNameDoesNotExistException e) {
			loginPanel.getErrorLabel().setText("User does not exist");
			loginPanel.getErrorLabel().setForeground(Color.red);
        }
    }

	private void registerUser(){
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		try{
			userDaoImpl.saveUser(new User(registrationPanel.getRegistrationDetails()));
			registrationPanel.getMessageLabel().setText("Registeration Successful");
			cardLayout.show(cardPanel, "login");
		} catch (UsernameOrEmailExistsException e) {
			registrationPanel.getMessageLabel().setText("Username or Email Exists! Please choose a unique username or Email.");
			registrationPanel.getMessageLabel().setForeground(Color.red);
        }
    }

}
