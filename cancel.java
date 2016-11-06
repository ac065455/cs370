import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cancel extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cancel frame = new cancel();
					frame.setVisible(true);
				}//try 
				catch (Exception e) {
					e.printStackTrace();
				}//catch
			}//run
		});
	}//main

	public cancel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 300, 350, 300);
		setSize(250,100);
		getContentPane().setLayout(null);
		
		JLabel lblAreYouSure = new JLabel("Are you sure you want to cancel?");
		lblAreYouSure.setBounds(22, 6, 238, 16);
		getContentPane().add(lblAreYouSure);
		
		JButton btnYes = new JButton("Yes");
		btnYes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}//actionPerformed
		});//addActionListener
		btnYes.setBounds(6, 34, 117, 29);
		getContentPane().add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.frmDatabase.setVisible(true);
			}//actionPerformed
		});//addActionLister
		btnNo.setBounds(127, 34, 117, 29);
		getContentPane().add(btnNo);
		
	}//cancel
}//cancel class
