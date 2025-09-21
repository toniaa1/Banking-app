package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Login;
import view.ApplicationView;
import view.LoginPage;

public class LoginController {
	private Login model;
	private LoginPage view;
	private ApplicationView appView;
	public LoginController(Login loginModel, LoginPage loginPage, ApplicationView appView) {
	    this.view = loginPage; 
	    this.model = loginModel;
	    this.appView = appView;

	    this.view.addLoginButtonListener(e -> {
	        String email = this.view.getEmail();
	        String password = this.view.getPassword();

	        if (email.isEmpty() || password.isEmpty()) {
	            this.view.displayError("Email or password cannot be empty.");
	            return;
	        }

	        boolean isAuthenticated = this.model.loginUser(email, password);

	        if (isAuthenticated) {
	            JOptionPane.showMessageDialog(null, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
	            this.appView.showMainPage(email);
	        } else {
	            this.view.displayError("Invalid email or password. Please try again.");
	        }
	    });
	}

	private class LoginButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String email=view.getEmail();
			String password=view.getPassword();
			try {
				Login logged=new Login();
				logged.loginUser(email, password);
			}
			catch(Exception ex){
				view.displayError(ex.getMessage());
			};
		}
	}
}
