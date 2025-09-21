package model;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import Pong.*;
import mainP.User;
public class MainM {
	
	public static class TransferPrompt implements ActionListener{
		private User user;
		public TransferPrompt(User user) {
	        this.user = user; 
		}
		@Override
	    public void actionPerformed(ActionEvent e) {
	        // Prompt for the transfer amount
			int userId = user.getId();
			
	        String amountStr = JOptionPane.showInputDialog(null, 
	                "Enter the amount to transfer:", 
	                "Transfer Amount", 
	                JOptionPane.QUESTION_MESSAGE);
	        if (amountStr == null) {
	            JOptionPane.showMessageDialog(null, "Transfer cancelled.");
	            return;
	        }

	        int amount = 0;
	        try {
	            amount = Integer.parseInt(amountStr);
	            if (amount <= 0) throw new NumberFormatException();
	        } catch (NumberFormatException b) {
	            JOptionPane.showMessageDialog(null, 
	                    "Invalid amount entered. Please enter a positive integer.", 
	                    "Error", 
	                    JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        
	        String recipientEmail = JOptionPane.showInputDialog(null, 
	                "Enter the recipient's email address:", 
	                "Recipient Email", 
	                JOptionPane.QUESTION_MESSAGE);
	        if (recipientEmail == null || recipientEmail.isBlank()) {
	            JOptionPane.showMessageDialog(null, "Transfer cancelled.");
	            return;
	        }

	        
	        int confirm = JOptionPane.showConfirmDialog(null, 
	                "Confirm transfer of " + amount + " to " + recipientEmail + "?", 
	                "Confirm Transfer", 
	                JOptionPane.YES_NO_OPTION);
	        if (confirm == JOptionPane.YES_OPTION) {
	            
	        	
	            Transfer transfer = new Transfer();
	            boolean success = transfer.transfer(amount, userId, recipientEmail);

	            if (success) {
	                JOptionPane.showMessageDialog(null, 
	                        "Transfer successful.", 
	                        "Success", 
	                        JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, 
	                        "Transfer failed. Please check the details and try again.", 
	                        "Error", 
	                        JOptionPane.ERROR_MESSAGE);
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Transfer cancelled.");
	        }
	    }
	}
	

	public static class AddCardPrompt implements ActionListener{
		private User user;
		public AddCardPrompt(User user) {
	        this.user = user; 
	    }
		
		@Override
	    public void actionPerformed(ActionEvent e) {
			int userId = user.getId();
			String cardNumber = JOptionPane.showInputDialog(null, 
	                "Enter the card number:", 
	                "Add Card - Card Number", 
	                JOptionPane.QUESTION_MESSAGE);
	        if (cardNumber == null || cardNumber.isBlank()) {
	            JOptionPane.showMessageDialog(null, "Operation cancelled.");
	            return;
	        }

	        String cvv = JOptionPane.showInputDialog(null, 
	                "Enter the card CVV:", 
	                "Add Card - CVV", 
	                JOptionPane.QUESTION_MESSAGE);
	        if (cvv == null || cvv.isBlank()) {
	            JOptionPane.showMessageDialog(null, "Operation cancelled.");
	            return;
	        }

	        String expirationDate = JOptionPane.showInputDialog(null, 
	                "Enter the card expiration date (YY/MM):", 
	                "Add Card - Expiration Date", 
	                JOptionPane.QUESTION_MESSAGE);
	        if (expirationDate == null || expirationDate.isBlank()) {
	            JOptionPane.showMessageDialog(null, "Operation cancelled.");
	            return;
	        }

	        String iban = JOptionPane.showInputDialog(null, 
	                "Enter the IBAN:", 
	                "Add Card - IBAN", 
	                JOptionPane.QUESTION_MESSAGE);
	        if (iban == null || iban.isBlank()) {
	            JOptionPane.showMessageDialog(null, "Operation cancelled.");
	            return;
	        }

	        String cardId = JOptionPane.showInputDialog(null, 
	                "Enter the card ID:", 
	                "Add Card - Card ID", 
	                JOptionPane.QUESTION_MESSAGE);
	        if (cardId == null || cardId.isBlank()) {
	            JOptionPane.showMessageDialog(null, "Operation cancelled.");
	            return;
	        }

	        int confirm = JOptionPane.showConfirmDialog(null, 
	                "Confirm adding the card to user ID " + userId + "?", 
	                "Confirm Add Card", 
	                JOptionPane.YES_NO_OPTION);
	        if (confirm == JOptionPane.YES_OPTION) {
	            AddCard addCard = new AddCard();
	            boolean success = addCard.addCard(cardNumber, cvv, expirationDate, iban, cardId, userId);

	            if (success) {
	                JOptionPane.showMessageDialog(null, 
	                        "Card added successfully.", 
	                        "Success", 
	                        JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, 
	                        "Failed to add card. Please check the details and try again.", 
	                        "Error", 
	                        JOptionPane.ERROR_MESSAGE);
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Operation cancelled.");
	        }
	    }
	}


	public static class AddFundsPrompt implements ActionListener {
		private User user;
		public AddFundsPrompt(User user) {
	        this.user = user; // Initialize the user object
	    }
		
		@Override
	    public void actionPerformed(ActionEvent e){
			int userId = user.getId();
	        String amountStr = JOptionPane.showInputDialog(null, 
	                "Enter the amount to add:", 
	                "Add Funds - Amount", 
	                JOptionPane.QUESTION_MESSAGE);
	        if (amountStr == null || amountStr.isBlank()) {
	            JOptionPane.showMessageDialog(null, "Operation cancelled.");
	            return;
	        }

	        int amount = 0;
	        try {
	            amount = Integer.parseInt(amountStr);
	            if (amount <= 0) throw new NumberFormatException();
	        } catch (NumberFormatException b) {
	            JOptionPane.showMessageDialog(null, 
	                    "Invalid amount entered. Please enter a positive integer.", 
	                    "Error", 
	                    JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        int confirm = JOptionPane.showConfirmDialog(null, 
	                "Confirm adding " + amount + " funds to user ID " + userId + "?", 
	                "Confirm Add Funds", 
	                JOptionPane.YES_NO_OPTION);
	        if (confirm == JOptionPane.YES_OPTION) {

	        	AddFunds addFunds = new AddFunds();
	            boolean success = addFunds.addFunds(amount, userId);

	            if (success) {
	                JOptionPane.showMessageDialog(null, 
	                        "Funds added successfully.", 
	                        "Success", 
	                        JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                JOptionPane.showMessageDialog(null, 
	                        "Failed to add funds. Please check the details and try again.", 
	                        "Error", 
	                        JOptionPane.ERROR_MESSAGE);
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Operation cancelled.");
	        }
	    }
	}

	
	public void startGame() {
		GameFrame game=new GameFrame();
	}
}
