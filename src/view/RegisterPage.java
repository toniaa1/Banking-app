package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class RegisterPage extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField NameBox;
    private JTextField textField_1; 
    private JPasswordField passwordField1; 
    private JPasswordField passwordField2; 
    private JButton RegisterButton; 

    public RegisterPage(CardLayout cardLayout, JPanel mainPanel) {
        this.setLayout(null);
        initialize(cardLayout, mainPanel);
    }

    private void initialize(CardLayout cardLayout, JPanel mainPanel) {
        this.setBackground(new Color(61, 172, 6));
        this.setBounds(0, 0, 810, 537);

        JButton GotoLogin = new JButton("Login");
        GotoLogin.addActionListener((ActionEvent e) -> {
            cardLayout.show(mainPanel, "LoginScreen");
        });
        GotoLogin.setBackground(Color.LIGHT_GRAY);
        GotoLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
        GotoLogin.setBounds(88, 383, 162, 43);
        this.add(GotoLogin);

        RegisterButton = new JButton("Register"); 
        RegisterButton.setBackground(Color.LIGHT_GRAY);
        RegisterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Register Button Clicked");
            }
        });
        RegisterButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
        RegisterButton.setBounds(88, 443, 162, 43);
        add(RegisterButton);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src/view/logo.png"));
        lblNewLabel.setBackground(new Color(0, 172, 0));
        lblNewLabel.setBounds(72, 97, 200, 260);
        add(lblNewLabel);

        JPanel panel = new JPanel();
        panel.setBounds(310, 0, 500, 537);
        add(panel);
        panel.setLayout(null);

        JLabel WelcomeLabel = new JLabel("Welcome :D");
        WelcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        WelcomeLabel.setBounds(178, 10, 142, 40);
        panel.add(WelcomeLabel);

        JLabel NameLabel = new JLabel("Enter your real name");
        NameLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        NameLabel.setBounds(31, 48, 218, 40);
        panel.add(NameLabel);

        NameBox = new JTextField();
        NameBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
        NameBox.setBounds(31, 93, 438, 40);
        panel.add(NameBox);
        NameBox.setColumns(10);

        JLabel EmailLabel = new JLabel("Enter your email");
        EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        EmailLabel.setBounds(31, 143, 218, 34);
        panel.add(EmailLabel);

        textField_1 = new JTextField(); 
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textField_1.setBounds(31, 187, 438, 40);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Enter your password");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(31, 237, 304, 40);
        panel.add(lblNewLabel_1);

        passwordField1 = new JPasswordField(); 
        passwordField1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordField1.setBounds(31, 287, 438, 40);
        panel.add(passwordField1);

        JLabel lblNewLabel_2 = new JLabel("Re-enter your password");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(31, 337, 253, 40);
        panel.add(lblNewLabel_2);

        passwordField2 = new JPasswordField(); 
        passwordField2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordField2.setBounds(31, 387, 438, 40);
        panel.add(passwordField2);
    }

    public String getName() {
        return NameBox.getText();
    }

    public String getEmail() {
        return textField_1.getText();
    }

    public String getPassword() {
        return new String(passwordField1.getPassword());
    }

    public String getRePassword() {
        return new String(passwordField2.getPassword());
    }

    public void displayError(String message) {
        JOptionPane.showMessageDialog(null, message, "Authentication Failed", JOptionPane.ERROR_MESSAGE);
    }

    public void addRegisterButtonListener(ActionListener actionListener) {
        RegisterButton.addActionListener(actionListener); 
    }
}
