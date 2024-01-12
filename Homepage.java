package banking_pro;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Homepage {
		public Homepage() {
			JFrame frame = new JFrame();
				
			JLabel hdLbl = new JLabel("Welcome to Banking Pro");
			hdLbl.setBounds(120, 80, 550, 46);
			Font font= new Font("", Font.ITALIC, 32);   
			hdLbl.setFont(font);
			frame.add(hdLbl);
			
			JLabel loginLbl = new JLabel("Let's Login:");
			loginLbl.setBounds(230, 140, 550, 46);
			Font fontLogin= new Font("", Font.ITALIC, 21);   
			loginLbl.setFont(fontLogin);
			frame.add(loginLbl);
			
			
			JLabel usernameLbl = new JLabel("Username:");
			usernameLbl.setBounds(140, 210, 100, 20);
			frame.add(usernameLbl);
			JTextField usernameField = new JTextField();
			usernameField.setBounds(250, 210, 180, 20);
			frame.add(usernameField);
			
			JLabel passwordLbl = new JLabel("Password:");
			passwordLbl.setBounds(140, 245, 100, 20);
			frame.add(passwordLbl);
			JTextField passwordField = new JTextField();
			passwordField.setBounds(250, 245, 180, 20);
			frame.add(passwordField);
			

			JButton btnLogin = new JButton("Login");
			btnLogin.setBounds(210, 295, 140, 27);
			frame.add(btnLogin);

			JButton btnCreate = new JButton("Create Account");
			btnCreate.setBounds(210, 375, 140, 30);
			frame.add(btnCreate);
			
			btnCreate.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
				    if(ae.getSource() == btnCreate){
			            setVisible(false);
			            new Menu_Part().setVisible(true);
				}
			});
			
			frame.setSize(650, 500);
			frame.setTitle("Banking Pro");
			frame.setLayout(null);
			frame.setVisible(true);
		}
			


	public static void main(String[] args) {
		new Homepage();
	}
}
