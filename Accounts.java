package banking_pro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Accounts {
	public static JPanel getFormUI() {
		
		JPanel panel = new JPanel();
		
		JLabel headerLbl = new JLabel("Create Account:");
		headerLbl.setBounds(182, 15, 100, 20);
		panel.add(headerLbl);
		
		JLabel fntLbl = new JLabel("First Name:");
		fntLbl.setBounds(50, 50, 100, 20);
		panel.add(fntLbl);
		JTextField fnField = new JTextField();
		fnField.setBounds(150, 50, 180, 20);
		panel.add(fnField);
		
		JLabel lntLbl = new JLabel("Last Name:");
		lntLbl.setBounds(50, 90, 100, 20);
		panel.add(lntLbl);
		JTextField lnField = new JTextField();
		lnField.setBounds(150, 90, 180, 20);
		panel.add(lnField);
		
		JLabel usernameLbl = new JLabel("Username:");
		usernameLbl.setBounds(50, 130, 100, 20);
		panel.add(usernameLbl);
		JTextField usernameField = new JTextField();
		usernameField.setBounds(150, 130, 180, 20);
		panel.add(usernameField);
		
		JLabel passwordLbl = new JLabel("Password:");
		passwordLbl.setBounds(50, 170, 100, 20);
		panel.add(passwordLbl);
		JTextField passwordField = new JTextField();
		passwordField.setBounds(150, 170, 180, 20);
		panel.add(passwordField);

		JLabel addressLbl = new JLabel("Address:");
		addressLbl.setBounds(50, 210, 100, 20);
		panel.add(addressLbl);
		JTextField addressField = new JTextField();
		addressField.setBounds(150, 210, 180, 20);
		panel.add(addressField);
		
		JLabel contactLbl = new JLabel("Contact:");
		contactLbl.setBounds(50, 250, 100, 20);
		panel.add(contactLbl);
		JTextField contactField = new JTextField();
		contactField.setBounds(150, 250, 180, 20);
		panel.add(contactField);
		
		JLabel genderLbl = new JLabel("Gender:");
		genderLbl.setBounds(50, 290, 100, 20);
		panel.add(genderLbl);
		ButtonGroup radioGroup = new ButtonGroup();
		JRadioButton rb1 = new JRadioButton("Male");
		rb1.setActionCommand("male");
		rb1.setBounds(150, 290, 100, 20);
		radioGroup.add(rb1);
		panel.add(rb1);
		JRadioButton rb2 = new JRadioButton("Female");
		rb2.setActionCommand("female");
		rb2.setBounds(250, 290, 150, 20);
		radioGroup.add(rb2); 
		panel.add(rb2);
		ButtonGroup group = new ButtonGroup();
		group.add(rb1);
	    group.add(rb2);
	      
		
		JLabel balanceLbl = new JLabel("Balance:");
		balanceLbl.setBounds(50, 330, 100, 20);
		panel.add(balanceLbl);
		JTextField balanceField = new JTextField();
		balanceField.setBounds(150, 330, 180, 21);
		panel.add(balanceField);

		
		JLabel chkBoxLbl = new JLabel("Provided Information is valid:");
		chkBoxLbl.setBounds(50, 370, 200, 30);
		panel.add(chkBoxLbl);
		JCheckBox chkBox = new JCheckBox("", true);
		chkBox.setBounds(250, 370, 200, 30);
		panel.add(chkBox);
		
		JButton sbtButton = new JButton("Submit");
		sbtButton.setBounds(250, 410, 90, 36);
		panel.add(sbtButton);
			
		sbtButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String firstname = fnField.getText();
				String lastname = lnField.getText();
				String username = usernameField.getText();
				String password = passwordField.getText();
				String address = addressField.getText();
				String contact = contactField.getText();
				String male = rb1.getText();
				String female = rb2.getText();
				String gender = group.getSelection().getActionCommand();
				String balance = ""+balanceField.getText();
				
				JDBCConnectionPart.save(firstname, lastname, username, password, address, contact, gender, balance);
			
				fnField.setText("");
				lnField.setText("");
				usernameField.setText("");
				passwordField.setText("");
				addressField.setText("");
				contactField.setText("");
				rb1.setText("");
				rb2.setText("");
				balanceField.setText("");
				
				JOptionPane.showMessageDialog(null, "Registration Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		panel.setLayout(null);
		return panel;
	}
	
}
