package view;

import javax.swing.*;

import Pong.GameFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mainP.User;
import model.MainM.AddCardPrompt;
import model.MainM.AddFundsPrompt;
import model.MainM.TransferPrompt;


public class MainPage extends JPanel {
	int id;
	String email;
	private String name;
    private JTextField textField;
    private JTextField textField_1;
    private JButton transferBtn;
    private JButton addCardBtn;
    private JButton addFundsBtn;
    private JButton gameBtn;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;

    public MainPage(User user) {
        initialize(user);
    }

    private void initialize(User user) {
        setLayout(null); 

        setBackground(new Color(240, 240, 240)); 
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(61, 172, 6));
        panel.setBounds(0, 0, 796, 82);
        add(panel);
        panel.setLayout(null);

        lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("src/view/symbols.png"));
        lblNewLabel.setBounds(348, 10, 70, 66);
        panel.add(lblNewLabel);
        
        
        
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 40));
        textField.setBackground(new Color(240, 240, 240));
        textField.setBounds(302, 182, 152, 76);
        textField.setBorder(null);
        textField.setText(String.valueOf(user.getBalance()));
        textField.setEditable(false);
        add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField("Hello" + user.getName());
        textField_1.setBackground(new Color(240, 240, 240));
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        textField_1.setBounds(0, 80, 376, 44);
        textField_1.setBorder(null);
        textField_1.setText("Hello " + user.getName());
        textField_1.setEditable(false);
        add(textField_1);
        textField_1.setColumns(10);

        JButton transferBtn = new JButton("Transfer");
        transferBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        transferBtn.setIcon(new ImageIcon("src/view/hand.png"));
        transferBtn.setHorizontalTextPosition(SwingConstants.CENTER); // Center horizontally
        transferBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        transferBtn.setBounds(60, 326, 164, 164);
        add(transferBtn);

        addCardBtn = new JButton("Add card");
        addCardBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addCardBtn.setIcon(new ImageIcon("src/view/card.png"));
        addCardBtn.setHorizontalTextPosition(SwingConstants.CENTER); // Center horizontally
        addCardBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        addCardBtn.setBounds(234, 326, 164, 164);
        add(addCardBtn);

        addFundsBtn = new JButton("Add funds");
        addFundsBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        addFundsBtn.setIcon(new ImageIcon("src/view/pig.png"));
        addFundsBtn.setHorizontalTextPosition(SwingConstants.CENTER); // Center horizontally
        addFundsBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        addFundsBtn.setBounds(408, 326, 164, 164);
        add(addFundsBtn);

        gameBtn = new JButton("Play with a friend!!");
        gameBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        gameBtn.setIcon(new ImageIcon("src/view/game.png"));
        gameBtn.setHorizontalTextPosition(SwingConstants.CENTER); 
        gameBtn.setVerticalTextPosition(SwingConstants.BOTTOM);
        gameBtn.setBounds(582, 326, 164, 164);
        add(gameBtn);

        lblNewLabel_1 = new JLabel("You have:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
        lblNewLabel_1.setBounds(292, 120, 192, 60);
        add(lblNewLabel_1);
        

        
        transferBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleTransfer(user);
            }
        });

        addCardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddCard(user);
            }
        });

        addFundsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleAddFunds(user);
            }
        });

        gameBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
    }
    
    private void handleTransfer(User user) {
        TransferPrompt transferPrompt = new TransferPrompt(user);
        transferPrompt.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
    }

    private void handleAddCard(User user) {
        AddCardPrompt addCardPrompt = new AddCardPrompt(user);
        addCardPrompt.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
    }

    private void handleAddFunds(User user) {
        AddFundsPrompt addFundsPrompt = new AddFundsPrompt(user);
        addFundsPrompt.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));

        textField.setText(String.valueOf(user.getBalance()));
    }

    private void startGame() {
        GameFrame game = new GameFrame();
        game.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        game.setVisible(true);
    }
}

