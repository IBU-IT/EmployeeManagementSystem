package ems;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class NewInfo {

	private JFrame NewInfo;
	private JTextField UsernameText;
	private JTextField PasswordText;
	private JTextField FirstnameText;
	private JTextField LastnameText;
	private JTextField TypeIDText;
	private JLabel lblNewUserid;
	public JTextField UserIDtext;
	public String UserID;
	public String Pass;
	public String Username;
	public String Firstname;
	public String Lastname;
	public String TypeID;

	/**
	 * Launch the application.
	 */
	public static void UserInterface() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewInfo window = new NewInfo();
					window.getNewInfo().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewInfo() {
		initialize();

	}

	private void initialize() {
		setNewInfo(new JFrame());
		getNewInfo().setVisible(true);
		getNewInfo().setResizable(false);
		getNewInfo().setIconImage(
				Toolkit.getDefaultToolkit().getImage(MainWindowAdmin.class.getResource("/images/burc.jpg")));
		getNewInfo().setTitle("Employee Management System");
		getNewInfo().setBounds(100, 100, 685, 436);
		getNewInfo().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		NewInfo.getContentPane().setLayout(null);

		JLabel lblNewUsername = new JLabel("New username:");
		lblNewUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewUsername.setBounds(132, 72, 100, 16);
		NewInfo.getContentPane().add(lblNewUsername);

		JLabel lblNewPassword = new JLabel("New password:");
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewPassword.setBounds(132, 101, 100, 16);
		NewInfo.getContentPane().add(lblNewPassword);

		JLabel label_5 = new JLabel("First name:");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(132, 130, 75, 16);
		NewInfo.getContentPane().add(label_5);

		JLabel label_6 = new JLabel("Last name:");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_6.setBounds(132, 159, 75, 16);
		NewInfo.getContentPane().add(label_6);

		JLabel label_11 = new JLabel("Type ID:");
		label_11.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_11.setBounds(132, 188, 75, 16);
		NewInfo.getContentPane().add(label_11);

		UsernameText = new JTextField();
		UsernameText.setBounds(256, 72, 116, 22);
		NewInfo.getContentPane().add(UsernameText);
		UsernameText.setColumns(10);

		PasswordText = new JTextField();
		PasswordText.setColumns(10);
		PasswordText.setBounds(256, 104, 116, 22);
		NewInfo.getContentPane().add(PasswordText);

		FirstnameText = new JTextField();
		FirstnameText.setColumns(10);
		FirstnameText.setBounds(256, 130, 116, 22);
		NewInfo.getContentPane().add(FirstnameText);

		LastnameText = new JTextField();
		LastnameText.setColumns(10);
		LastnameText.setBounds(256, 159, 116, 22);
		NewInfo.getContentPane().add(LastnameText);

		TypeIDText = new JTextField();
		TypeIDText.setColumns(10);
		TypeIDText.setBounds(256, 188, 116, 22);
		NewInfo.getContentPane().add(TypeIDText);

		UserIDtext = new JTextField();
		UserIDtext.setColumns(10);
		UserIDtext.setBounds(256, 38, 116, 22);
		NewInfo.getContentPane().add(UserIDtext);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					UserID = UserIDtext.getText();
					Pass = PasswordText.getText();
					Username = UsernameText.getText();
					Firstname = FirstnameText.getText();
					Lastname = LastnameText.getText();
					TypeID = TypeIDText.getText();
					Connection myConn = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/nova_sema?autoReconnect=true&useSSL=false", "root",
							"pasvordzasql");
					Statement myStmt = myConn.createStatement();

					int result = myStmt.executeUpdate("INSERT INTO users " + "VALUES ('" + UserID + "', '" + Username
							+ "','" + Pass + "','" + Firstname + "','" + Lastname + "',0,'" + TypeID + "' )");
					JOptionPane.showMessageDialog(null, "The "+Username+" user has been added");

					myConn.close();
				} catch (Exception e1) {
					System.err.println("Got an exception! ");
					System.err.println(e1.getMessage());

				}
				
			}
		});
		btnConfirm.setBounds(211, 232, 97, 25);
		NewInfo.getContentPane().add(btnConfirm);

		lblNewUserid = new JLabel("New userID");
		lblNewUserid.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewUserid.setBounds(132, 41, 100, 16);
		NewInfo.getContentPane().add(lblNewUserid);

	}

	public JFrame getNewInfo() {
		return NewInfo;
	}

	public void setNewInfo(JFrame NewInfo) {
		this.NewInfo = NewInfo;
		NewInfo.getContentPane().setBackground(Color.WHITE);
	}
}
