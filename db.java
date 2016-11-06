import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class db {

	static JFrame frmDatabase;
	private JTextField textField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				db window = new db();
				window.frmDatabase.setVisible(true);
			}// run
		});
	}// main

	public db() {
		initialize();
	}// constructor

	private void initialize() {
		frmDatabase = new JFrame();
		frmDatabase.setTitle("Database");
		frmDatabase.getContentPane().setBackground(new Color(255, 204, 153));
		frmDatabase.setBounds(300, 100, 450, 300);
		frmDatabase.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDatabase.getContentPane().setLayout(null);
		frmDatabase.setSize(600, 600);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblUsername.setBounds(81, 447, 92, 16);
		frmDatabase.getContentPane().add(lblUsername);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblPassword.setBounds(81, 493, 92, 27);
		frmDatabase.getContentPane().add(lblPassword);

		JLabel label = new JLabel("");
		Image db = new ImageIcon(this.getClass().getResource("/database.png")).getImage();
		label.setIcon(new ImageIcon(db));
		label.setBounds(38, 39, 530, 368);
		frmDatabase.getContentPane().add(label);

		// create textfield to enter username
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textField.setBounds(234, 438, 165, 33);
		frmDatabase.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel label_1 = new JLabel("");
		Image user = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		label_1.setIcon(new ImageIcon(user));
		label_1.setBounds(182, 438, 32, 33);
		frmDatabase.getContentPane().add(label_1);

		// create passwordField to enter password
		passwordField = new JPasswordField();
		passwordField.setBounds(234, 490, 165, 35);
		frmDatabase.getContentPane().add(passwordField);

		JLabel label_2 = new JLabel("");
		Image lock = new ImageIcon(this.getClass().getResource("/lock.png")).getImage();
		label_2.setIcon(new ImageIcon(lock));
		label_2.setBounds(182, 490, 32, 33);
		frmDatabase.getContentPane().add(label_2);

		// creates "Database" text on top of database image
		JLabel lblDatabase = new JLabel("Database");
		lblDatabase.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblDatabase.setBounds(258, 11, 92, 16);
		frmDatabase.getContentPane().add(lblDatabase);

		// create login button
		final JButton btnLogin = new JButton("Log-in");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exception) {
				String username = "root";
				String password = "root";
				String text = textField.getText();
				String pass = passwordField.getText();
				try {
					if (text.equals(username) && pass.equals(password)) {
						btnLogin.addActionListener(this); // on Log-in click,
															// open new JFrame
						data myData = new data(); // create new data object
						myData.setVisible(true); // allow visibility of JFrame
					} // if
					else {
						invalid invalidMenu = new invalid();
						invalidMenu.setVisible(true);
						textField.setText("");
						passwordField.setText("");
					} // else
				} // try
				catch (Exception e) {
					JOptionPane.showMessageDialog(null, e);
				} // catch
			}// actionPerformed

		});// addActionListener
		btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnLogin.setBounds(421, 434, 135, 44);
		frmDatabase.getContentPane().add(btnLogin);

		// cancel button
		final JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// if pressed, prompt user are you sure if you want to cancel.
				// if yes, close JFrame, else continue
				try {
					btnCancel.addActionListener(this);
					cancel cancelPage = new cancel();
					cancelPage.setVisible(true);
				} // try
				catch (Exception exception) {
					JOptionPane.showMessageDialog(null, e);
				} // catch
			}// actionPerformed
		});
		btnCancel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnCancel.setBounds(421, 488, 135, 43);
		frmDatabase.getContentPane().add(btnCancel);

	}// initialize
}// db
