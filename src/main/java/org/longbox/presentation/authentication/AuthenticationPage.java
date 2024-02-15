package org.longbox.presentation.authentication;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.longbox.businesslogic.UserSession;
import org.longbox.domainobjects.dto.UserDTO;
import org.longbox.persistence.stubdatabase.UserStubDB;
import org.longbox.presentation.profile.HomePage;

public class AuthenticationPage extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel cardPanel;
	private CardLayout cardLayout;
    private LoginPage loginPage = new LoginPage();
    private RegistrationPage registrationPage = new RegistrationPage();
    private UserStubDB user = new UserStubDB();
    private UserSession userSession;
    private UserSession userLoggedIn;
    private List<UserDTO> users;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AuthenticationPage frame = new AuthenticationPage();
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
	public AuthenticationPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 550);
        setTitle("LongBox");
        
        //loads the users
        user.loadUsers();
        
        setLocationRelativeTo(null);
        
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        cardPanel.add(loginPage, "login");
        cardPanel.add(registrationPage, "registration");

        // Set the default panel to login page
        cardLayout.show(cardPanel, "login");

        add(cardPanel);
        setVisible(true);
        
        // login page buttons action listener
        loginPage.getSignUpButton().addActionListener(this);
        loginPage.getSignInButton().addActionListener(this);
        
        //registration page buttons action listener
        registrationPage.getSignInButton().addActionListener(this);
		registrationPage.getSignUpButton().addActionListener(this);
		
	}
	
	@Override
    public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginPage.getSignUpButton()) {
            cardLayout.show(cardPanel, "registration");
        }else if(e.getSource() ==  registrationPage.getSignInButton()) {
        	cardLayout.show(cardPanel, "login");
        }else if(e.getSource() == loginPage.getSignInButton()) {
        	users = user.getUsers();
        	for(UserDTO u: users) {
        		if(loginPage.getUsername().equals(u.getUserName())) {
        			if(loginPage.getDecryptedPassword().equals(u.getPassword())) {
        				userLoggedIn = userSession.getInstance(u);
        				loginPage.getErrorLabel().setText("Login Successful!");
        				loginPage.getErrorLabel().setForeground(Color.GREEN);
        				dispose();
        				HomePage homePage = new HomePage(userLoggedIn);
        				homePage.setVisible(true);
      
        			}else {
        				loginPage.getErrorLabel().setText("Passowrd Incorrect");
        				loginPage.getErrorLabel().setForeground(Color.red);
        			}
        		}else {
        			loginPage.getErrorLabel().setText("User does not exist");
        			loginPage.getErrorLabel().setForeground(Color.red);
        		}
        	}
        }else if(e.getSource() == registrationPage.getSignUpButton()) {
        	user.addUser(registrationPage.getRegisterationDetails());
        	registrationPage.getMessageLabel().setText("Registeration Successful");
        	cardLayout.show(cardPanel, "login");
        }
    }
}
