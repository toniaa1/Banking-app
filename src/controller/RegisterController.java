package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Register;
import view.RegisterPage;

public class RegisterController {
	private Register model;
	private RegisterPage view;
	public RegisterController(Register model, RegisterPage view){
		this.model=model;
		this.view=view;
		view.addRegisterButtonListener(new RegisterButtonListener());
		view.setVisible(true);
	}
	private class RegisterButtonListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String name=view.getName();
			String email=view.getEmail();
			String password=view.getPassword();
			try {
				Register registered=new Register();
				registered.registerUser(name, email, password);
			}
			catch(Exception ex){
				view.displayError(ex.getMessage());
			};
		}
	}
}
