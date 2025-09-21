package view;
import javax.swing.*;
import java.awt.*;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import model.Login;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import mainP.User;
public class LoginPage extends JPanel{
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField EmailField;
	private JPasswordField passwordField1;
	private JButton LoginButton;
	
	public LoginPage(CardLayout cardLayout, JPanel mainPanel) {
	    this.setLayout(null); 
	    initialize(cardLayout, mainPanel);
	}

	
	private void initialize(CardLayout cardLayout, JPanel mainPanel) {
	    this.setBackground(new Color(61, 172, 6)); 
	    this.setBounds(0, 0, 810, 537);

	    LoginButton = new JButton("Login");
	    LoginButton.setBackground(Color.LIGHT_GRAY);
	    LoginButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    LoginButton.setBounds(88, 383, 162, 43);
	    this.add(LoginButton);

	    JButton RegisterButton = new JButton("Register");
	    RegisterButton.addActionListener((ActionEvent e) -> {
	        cardLayout.show(mainPanel, "RegisterScreen");
	    });
	    RegisterButton.setBackground(Color.LIGHT_GRAY);
	    RegisterButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    RegisterButton.setBounds(88, 436, 162, 43);
	    this.add(RegisterButton);

	    JLabel lblNewLabel_3 = new JLabel("");
	    lblNewLabel_3.setIcon(new ImageIcon("src/view/logo.png"));
	    lblNewLabel_3.setBounds(74, 80, 197, 260);
	    this.add(lblNewLabel_3);

	    JPanel panel = new JPanel();
	    panel.setBounds(304, 0, 506, 537);
	    add(panel);
	    panel.setLayout(null);

	    JLabel WelcomeLabel = new JLabel("Welcome:D");
	    WelcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    WelcomeLabel.setBounds(182, 10, 143, 39);
	    panel.add(WelcomeLabel);

	    EmailField = new JTextField();
	    EmailField.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    EmailField.setBounds(36, 128, 387, 39);
	    panel.add(EmailField);
	    EmailField.setColumns(10);

	    JLabel EmailLabel = new JLabel("Enter your email");
	    EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    EmailLabel.setBounds(36, 84, 194, 34);
	    panel.add(EmailLabel);

	    JLabel PasswordLabel = new JLabel("Enter your password");
	    PasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    PasswordLabel.setBounds(36, 221, 387, 39);
	    panel.add(PasswordLabel);

	    passwordField1 = new JPasswordField();
	    passwordField1.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    passwordField1.setBounds(36, 286, 387, 39);
	    panel.add(passwordField1);
	}
	public String getEmail() {
	    return EmailField.getText().trim(); 
	}

	public String getPassword() {
	    return new String(passwordField1.getPassword()).trim();
	}
	
	public void addLoginButtonListener(ActionListener actionListener){
        LoginButton.addActionListener(actionListener);
        
    }
	public void displayError(String message){
        JOptionPane.showMessageDialog(null, message, "Authantication did not work", JOptionPane.ERROR_MESSAGE);
    }
}
