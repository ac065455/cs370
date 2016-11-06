import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class invalid extends JFrame {

	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					invalid frame = new invalid();
					frame.setVisible(true);
				}//try 
				catch (Exception e) {
					e.printStackTrace();
				}//catch
			}//run
		});
	}//main

	public invalid() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 450, 300);
		setSize(250,100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInvalidLogin = new JLabel("Invalid log-in. Try again.");
		lblInvalidLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblInvalidLogin.setBounds(30, 6, 213, 28);
		contentPane.add(lblInvalidLogin);
		
		JButton btnYes = new JButton("OK");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.frmDatabase.setVisible(true);
			}//actionPerformed
		});
		btnYes.setBounds(60, 42, 117, 29);
		contentPane.add(btnYes);
	}//invalid
}//class
