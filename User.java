import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class User extends JFrame {

	private JPanel contentPane;
	private int BookID;
	private String BookName;
	private double SellPrice;
	private int QtyInventory;
	private int Threshold;

	public User(int BookID, String BookName, double SellPrice, int QtyInventory, int Threshold) {
		this.BookID = BookID;
		this.BookName = BookName;
		this.SellPrice = SellPrice;
		this.QtyInventory = QtyInventory;
		this.Threshold = Threshold;
	}//user
	
	public int getBookID(){
		return BookID;
	}//getBookID

	public String getBookName(){
		return BookName;
	}//getBookID
	
	public double getSellPrice(){
		return SellPrice;
	}//getBookID
	
	public int getQtyInventory(){
		return QtyInventory;
	}//getBookID
	
	public int getThreshold(){
		return BookID;
	}//getBookID

}//User
