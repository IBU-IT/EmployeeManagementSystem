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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NewInfo {

	private JFrame NewInfo;
	private JTextField UsernameText;
	private JTextField PasswordText;
	private JTextField FirstnameText;
	private JTextField LastnameText;
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
		getNewInfo().setLocationRelativeTo(null);
		getNewInfo().setVisible(true);
		NewInfo.getContentPane().setLayout(null);

		UsernameText = new JTextField();
		UsernameText.setBounds(255, 41, 116, 22);
		NewInfo.getContentPane().add(UsernameText);
		UsernameText.setColumns(10);

		PasswordText = new JTextField();
		PasswordText.setBounds(255, 72, 116, 22);
		PasswordText.setColumns(10);
		NewInfo.getContentPane().add(PasswordText);

		FirstnameText = new JTextField();
		FirstnameText.setBounds(255, 98, 116, 22);
		FirstnameText.setColumns(10);
		NewInfo.getContentPane().add(FirstnameText);

		LastnameText = new JTextField();
		LastnameText.setBounds(255, 127, 116, 22);
		LastnameText.setColumns(10);
		NewInfo.getContentPane().add(LastnameText);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(147, 232, 97, 25);
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int UserType = 0;
				if (MyMethods.getGlobTypeStr().equals("Admin")) {
					UserType = 1;
				}
				else if (MyMethods.getGlobTypeStr().equals("Employee")) {
					UserType = 2;
				}
				int salary = Integer.parseInt(idText.getText());
				String Pass = PasswordText.getText();
				String Username = UsernameText.getText();
				String Firstname = FirstnameText.getText();
				String Lastname = LastnameText.getText();
				
				MyMethods mthds = new MyMethods();
				mthds.newUser(salary, Username, Pass, Firstname, Lastname, UserType);
				getNewInfo().setVisible(false);
			}
		});
		NewInfo.getContentPane().add(btnConfirm);
		
		JLabel lblUserId = new JLabel("Salary per hour:");
		lblUserId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserId.setBounds(100, 183, 144, 16);
		lblUserId.setFont(new Font("Tahoma", Font.BOLD, 13));
		NewInfo.getContentPane().add(lblUserId);
		
		idText = new JTextField();
		idText.setBounds(255, 181, 116, 22);
		idText.setColumns(10);
		NewInfo.getContentPane().add(idText);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBounds(256, 233, 97, 25);
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getNewInfo().setVisible(false);
			}
		});
		NewInfo.getContentPane().add(btnCancel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(255, 155, 116, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Employee"}));
		MyMethods.setGlobTypeStr((String)comboBox.getSelectedItem());
		NewInfo.getContentPane().add(comboBox);
		
		JLabel lblUserType = new JLabel("User type:");
		lblUserType.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserType.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUserType.setBounds(100, 159, 144, 16);
		NewInfo.getContentPane().add(lblUserType);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(101, 132, 144, 16);
		NewInfo.getContentPane().add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstName.setBounds(101, 103, 144, 16);
		NewInfo.getContentPane().add(lblFirstName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(101, 74, 144, 16);
		NewInfo.getContentPane().add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(100, 45, 144, 16);
		NewInfo.getContentPane().add(lblUsername);

	}

	public JFrame getNewInfo() {
		return NewInfo;
	}

	public void setNewInfo(JFrame NewInfo) {
		this.NewInfo = NewInfo;
		NewInfo.getContentPane().setBackground(Color.WHITE);
	}
}
