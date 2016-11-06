import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class data extends JFrame {

	Connection myConn = null;
	static String username = "root";
	static String password = "root";
	static String url = "jdbc:mysql://localhost:3306/software engineering";
	private JPanel contentPane;
	private JButton btnNewButton;
	static JTable table_2;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					data frame = new data();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}//catch
			}//run
		});
	}//main
	
	//Connection myConn = null;
//	static JTable table_2;
//	private JTextField textField_2;
//	private JTextField textField_3;
//	private JTextField textField_4;
//	private JTextField textField;
//	private JTextField textField_1;
	
	public data() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(130, 30, 450, 300);
		setSize(1000,700);
		setTitle("Database");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblDatabase = new JLabel("Database");
		lblDatabase.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table_2.getSelectedRow();
				textField.setText(table_2.getModel().getValueAt(i, 0).toString());
				textField_1.setText(table_2.getModel().getValueAt(i, 1).toString());
				textField_2.setText(table_2.getModel().getValueAt(i, 2).toString());
				textField_3.setText(table_2.getModel().getValueAt(i, 3).toString());
				textField_4.setText(table_2.getModel().getValueAt(i, 4).toString());
			}//mouseClicked
		});
		table_2.setModel(new DefaultTableModel(new Object[][]{},new String[]{"BookID", "BookName", "SellPrice", 
				"QtyInventory", "Threshold"}));
		scrollPane.setViewportView(table_2);
		
		//insert data into database
		JButton btnLoadData = new JButton("Insert");
		btnLoadData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "insert into `software engineering`.`books` (`BookID`,`BookName`,`SellPrice`,`QtyInventory`,`Threshold`) values ('"+textField.getText()+ "','"+textField.getText()+ "','"+textField.getText()+ "','"+textField.getText()+ "','"+textField.getText()+ "')";
				int numCols = table_2.getModel().getColumnCount();
				Object[] data = new Object[numCols];
				data[0] = textField.getText();
				data[1] = textField_1.getText();
				data[2] = textField_2.getText();
				data[3] = textField_3.getText();
				data[4] = textField_4.getText();
				((DefaultTableModel) table_2.getModel()).addRow(data);
				executeQuery(query,"Inserted");
			}//actionPerformed
		});
		btnLoadData.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblBookid = new JLabel("Book ID:");
		lblBookid.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblBookName = new JLabel("Book Name:");
		lblBookName.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblSellPrice = new JLabel("Sell Price:");
		lblSellPrice.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblQtyInventory = new JLabel("Qty Inventory:");
		lblQtyInventory.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JLabel lblThreshold = new JLabel("Threshold:");
		lblThreshold.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		//sell Price
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textField_2.setColumns(10);
		
		//Qty Inventory
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textField_3.setColumns(10);
		
		//Threshold
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textField_4.setColumns(10);
		
		//Bookid
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textField.setColumns(10);
		
		//update data from database
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "UPDATE `software engineering`.`books` SET `BookID`='6', `BookName`='5', `SellPrice`='2', `QtyInventory`='1' WHERE `BookID`='6'";

				int i = table_2.getSelectedRow();
				((DefaultTableModel) table_2.getModel()).setValueAt(textField.getText(),i,0);
				((DefaultTableModel) table_2.getModel()).setValueAt(textField_1.getText(),i,1);
				((DefaultTableModel) table_2.getModel()).setValueAt(textField_2.getText(),i,2);
				((DefaultTableModel) table_2.getModel()).setValueAt(textField_3.getText(),i,3);
				((DefaultTableModel) table_2.getModel()).setValueAt(textField_4.getText(),i,4);
				executeQuery(query,"Updated");
			}//actionPerformed
		});
		
		btnUpdate.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		//delete data from database
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query = "delete from `software engineering`.`books` where BookID = "+textField.getText();
				int i = table_2.getSelectedRow();
				if(i >= 0){
					((DefaultTableModel) table_2.getModel()).removeRow(i);
					executeQuery(query,"Deleted");
				}//if
				else{
					JOptionPane.showMessageDialog(null, "Delete error");
				}//else
			}//actionPerformed
		});
		btnDelete.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		//BookName
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		textField_1.setColumns(10);
		
		JButton btnLoadData_1 = new JButton("Load Data");
		btnLoadData_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showData();
			}//actionPerformed
		});
		btnLoadData_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JButton btnConnectToDatabase = new JButton("Connect to DataBase");
		btnConnectToDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getConnection();
			}//actionPerformed
		});
		btnConnectToDatabase.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}//actionPerformed
		});
		btnExit.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(38, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(32)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblBookName)
												.addComponent(lblBookid)
												.addComponent(lblSellPrice)
												.addComponent(lblQtyInventory)
												.addComponent(lblThreshold))
											.addGap(18)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
												.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnLoadData, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnUpdate)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnDelete))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(19)
									.addComponent(btnConnectToDatabase)))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnLoadData_1)
							.addGap(98))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnExit)
							.addGap(18)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(81, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
							.addComponent(lblDatabase, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
							.addGap(290))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDatabase)
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 579, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addComponent(btnConnectToDatabase)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblBookid)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblBookName)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblSellPrice)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblQtyInventory)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblThreshold)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLoadData, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnUpdate)
								.addComponent(btnDelete))
							.addGap(34)
							.addComponent(btnLoadData_1)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnExit)))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}//data constructor
	
	public static Connection getConnection() {
		Connection myConn;
		try {
			myConn = DriverManager.getConnection(url, username, password);
			return myConn;
		} // try
		catch (Exception e) {
			e.printStackTrace();
			return null;
		} // catch
	}// getConnection
	
	public static ArrayList<User> getBooksList() {
		ArrayList<User> booksList = new ArrayList<User>();
		Connection connection = getConnection();
		String query = "select * from books";
		Statement st;
		ResultSet rs;
		try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			User books;
			while (rs.next()) {
				books = new User(rs.getInt("BookID"), rs.getString("BookName"), rs.getDouble("SellPrice"),
						rs.getInt("QtyInventory"), rs.getInt("Threshold"));
				booksList.add(books);
			} // while
		} // try
		catch (Exception ex) {
			ex.printStackTrace();
		} // catch
		return booksList;
	}// booksList

	public static void showData() {
		ArrayList<User> list = getBooksList();
		DefaultTableModel model = new DefaultTableModel();
		model = (DefaultTableModel) data.table_2.getModel();
		Object[] row = new Object[5];
		for (int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getBookID();
			row[1] = list.get(i).getBookName();
			row[2] = list.get(i).getSellPrice();
			row[3] = list.get(i).getQtyInventory();
			row[4] = list.get(i).getThreshold();

			model.addRow(row);
		} // for
	}//showData
	
	public void executeQuery(String query, String message){
		Connection myConn = getConnection();
		Statement st;
		try{
			st = myConn.createStatement();
			if(st.executeUpdate(query) == 1){
				//refresh database
				DefaultTableModel model = (DefaultTableModel) table_2.getModel();
				model.setRowCount(0);
				showData();
				JOptionPane.showMessageDialog(null, "Data " + message + " Successfully.");
			}//if
			else{
				JOptionPane.showMessageDialog(null, "Data not " + message);
			}//else
		}catch(Exception e){
			e.printStackTrace();
		}//catch
	}//executeQuery
	
}//data class
