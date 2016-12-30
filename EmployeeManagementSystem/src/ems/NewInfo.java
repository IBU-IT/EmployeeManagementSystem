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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewInfo {

	private JFrame NewInfo;
	private JTextField UsernameText;
	private JTextField PasswordText;
	private JTextField FirstnameText;
	private JTextField LastnameText;
	private JTextField TypeIDText;
	public String UserID;
	public String Pass;
	public String Username;
	public String Firstname;
	public String Lastname;
	public String TypeID;
	private JTextField idText;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void UserInterface() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewInfo window = new NewInfo();
					window.getNewInfo().setLocationRelativeTo(null);
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
		
		getNewInfo().setResizable(false);
		getNewInfo().setIconImage(
				Toolkit.getDefaultToolkit().getImage(MainWindowAdmin.class.getResource("/images/burc.jpg")));
		getNewInfo().setTitle("Employee Management System");
		getNewInfo().setSize( 508, 335);
		getNewInfo().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		NewInfo.getContentPane().setLayout(null);
		getNewInfo().setLocationRelativeTo(null);
		getNewInfo().setVisible(true);
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

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int UserID = Integer.parseInt(idText.getText());
				String Pass = PasswordText.getText();
				String Username = UsernameText.getText();
				String Firstname = FirstnameText.getText();
				String Lastname = LastnameText.getText();
				int TypeID = Integer.parseInt(TypeIDText.getText());
				MyMethods mthds = new MyMethods();
				mthds.newUser(Username, Pass, Firstname, Lastname, TypeID);
				getNewInfo().setVisible(false);
			}
		});
		btnConfirm.setBounds(147, 232, 97, 25);
		NewInfo.getContentPane().add(btnConfirm);
		
		JLabel lblUserId = new JLabel("User ID");
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserId.setBounds(132, 43, 100, 16);
		NewInfo.getContentPane().add(lblUserId);
		
		idText = new JTextField();
		idText.setColumns(10);
		idText.setBounds(256, 43, 116, 22);
		NewInfo.getContentPane().add(idText);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getNewInfo().setVisible(false);
			}
		});
		btnCancel.setBounds(256, 233, 97, 25);
		NewInfo.getContentPane().add(btnCancel);

	}

	public JFrame getNewInfo() {
		return NewInfo;
	}

	public void setNewInfo(JFrame NewInfo) {
		this.NewInfo = NewInfo;
		NewInfo.getContentPane().setBackground(Color.WHITE);
	}
}
