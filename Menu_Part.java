package banking_pro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Menu_Part{
		public Menu_Part() {
			JFrame frame = new JFrame();
			
			JPanel addPanel = Accounts.getFormUI();
			frame.add(addPanel);
			JPanel listPanel = new JPanel();
			listPanel.setVisible(false);
			
			JMenuBar menuBar = new JMenuBar();
			frame.setJMenuBar(menuBar);
			
			JMenu fileMenu = new JMenu("File");
			menuBar.add(fileMenu);
			JMenu fileHelp = new JMenu("Help");
			menuBar.add(fileHelp);	
			
			JMenuItem addItem = new JMenuItem("Add");
			fileMenu.add(addItem);
			JMenuItem listItem = new JMenuItem("List");
			fileMenu.add(listItem);
			JMenuItem depositItem = new JMenuItem("Deposit");
			fileMenu.add(depositItem);
			JMenuItem withdrawItem = new JMenuItem("Withdraw");
			fileMenu.add(withdrawItem);
			JMenuItem transferItem = new JMenuItem("Transfer");
			fileMenu.add(transferItem);
			JMenuItem exitItem = new JMenuItem("Exit");
			fileMenu.add(exitItem);
			

			addItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addPanel.setVisible(true);
					listPanel.setVisible(false);
					frame.add(addPanel);
					frame.pack();
				}
			});
			
			listItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					listPanel.removeAll();
					listPanel.add(new JScrollPane(TableInfo.getTableUI()));
					addPanel.setVisible(false);
					listPanel.setVisible(true);
					frame.add(listPanel);
					frame.pack();
				}
			});
			
			
			exitItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			
			frame.setTitle("Create Account");
			frame.setSize(680,550);
			frame.setVisible(true);
		}
		
	public static void main(String[] args) {
		new Menu_Part();
	}

}
