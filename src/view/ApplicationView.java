package view;

import javax.swing.*;
import java.awt.CardLayout;
import model.*;
import controller.*;
import mainP.User;
public class ApplicationView {
    public JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private MainPage mainPage;
    private LoginController logincontrol;
    private RegisterController registercontrol;

    
    public ApplicationView() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 810, 537);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        loginPage = new LoginPage(cardLayout, mainPanel);
        registerPage = new RegisterPage(cardLayout, mainPanel);
        

        Login loginModel = new Login();
        Register registerModel = new Register();
        MainM mainp = new MainM();

        logincontrol = new LoginController(loginModel, loginPage, this);
        registercontrol = new RegisterController(registerModel, registerPage);
    

        mainPanel.add("LoginScreen", loginPage);
        mainPanel.add("RegisterScreen", registerPage);
        
        frame.getContentPane().add(mainPanel);

        cardLayout.show(mainPanel, "LoginScreen");

        frame.setVisible(true);
    }
    
    public void showMainPage(String email) {
        User user = new User(email); 

        mainPage = new MainPage(user);

        mainPanel.add("MainScreen", mainPage);
        
        cardLayout.show(mainPanel, "MainScreen");
    }

    
    public String getEmailFromLogin() {
    	return loginPage.getEmail();
    }
}
