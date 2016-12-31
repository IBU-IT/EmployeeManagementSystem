package ems;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JToolBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import javax.swing.ImageIcon;

public class MainWindowAdmin {

	private JLabel lblClock;
	private JFrame frmEmployeeManagementSystem;

	/**
	 * Launch the application.
	 */
	public static void UserInterface() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindowAdmin window = new MainWindowAdmin();
					window.getFrmEmployeeManagementSystem().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					for (;;) {
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH);
						int year = cal.get(Calendar.YEAR);

						int second = cal.get(Calendar.SECOND);
						int minute = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR);
						lblClock.setText("Time: " + hour + ":" + minute + ":" + second + "       Date: " + day + "/"
								+ month + "/" + year);

						sleep(1000);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		};
		clock.start();
	}

	/**
	 * Create the application.
	 */
	public MainWindowAdmin() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmEmployeeManagementSystem(new JFrame());
		getFrmEmployeeManagementSystem().setResizable(false);
		getFrmEmployeeManagementSystem().getContentPane().setBackground(Color.WHITE);
		getFrmEmployeeManagementSystem().setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindowAdmin.class.getResource("/images/burc.jpg")));
		getFrmEmployeeManagementSystem().setTitle("Employee Management System");
		getFrmEmployeeManagementSystem().setSize( 685, 436);
		getFrmEmployeeManagementSystem().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmEmployeeManagementSystem().getContentPane().setLayout(null);
		getFrmEmployeeManagementSystem().setLocationRelativeTo(null);
		getFrmEmployeeManagementSystem().setVisible(true);
		JButton btnExit = new JButton("EXIT");
		btnExit.setFocusPainted(false);
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(580, 373, 89, 23);
		getFrmEmployeeManagementSystem().getContentPane().add(btnExit);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setFocusPainted(false);
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getFrmEmployeeManagementSystem().setVisible(false);
				LoginKlasa frame = new LoginKlasa();
				frame.setVisible(true);
				
			}
			
		});
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnLogout.setBounds(481, 373, 89, 23);
		getFrmEmployeeManagementSystem().getContentPane().add(btnLogout);
		
		JLabel lblAdminWindow = new JLabel("Admin Window");
		lblAdminWindow.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdminWindow.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminWindow.setBounds(414, 50, 255, 49);
		getFrmEmployeeManagementSystem().getContentPane().add(lblAdminWindow);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		JButton btnCheck = new JButton("GET A FULL USER REPORT");
		btnCheck.setFocusPainted(false);
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkHours window = new checkHours();
				window.frmEmsCheck.setVisible(true);
				
			}
		});
		btnCheck.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCheck.setBounds(10, 11, 271, 49);
		getFrmEmployeeManagementSystem().getContentPane().add(btnCheck);
		
		JButton btnNewButton = new JButton("ADD NEW USER");
		btnNewButton.setFocusPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 NewInfo ni = new NewInfo();
			}
			
		});
		btnNewButton.setBounds(10, 73, 271, 49);
		frmEmployeeManagementSystem.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CHANGE USER PASSWORD");
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				NewPass np = new NewPass();
				
				
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(10, 135, 271, 49);
		frmEmployeeManagementSystem.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE USER");
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DeleteUser window3 = new DeleteUser();
				
							}
			
				
			
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(10, 197, 271, 49);
		frmEmployeeManagementSystem.getContentPane().add(btnNewButton_2);
		
	
		lblClock = new JLabel("Date&Time");
		lblClock.setBounds(10, 376, 297, 16);
		frmEmployeeManagementSystem.getContentPane().add(lblClock);
		
		JButton btnCalculateSalary = new JButton("CALCULATE SALARY");
		btnCalculateSalary.setFocusPainted(false);
		btnCalculateSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCalculateSalary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkSalary window = new checkSalary();
				
				
				
				
			}
		});
		btnCalculateSalary.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCalculateSalary.setBounds(10, 257, 271, 49);
		frmEmployeeManagementSystem.getContentPane().add(btnCalculateSalary);
		
		JButton btnChangeSalary = new JButton("CHANGE SALARY");
		btnChangeSalary.setFocusPainted(false);
		btnChangeSalary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ChangeSalary window = new ChangeSalary();
				window.getNewPass().setVisible(true);
			}
		});
		btnChangeSalary.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChangeSalary.setBounds(10, 317, 271, 49);
		frmEmployeeManagementSystem.getContentPane().add(btnChangeSalary);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(440, 102, 197, 86);
		frmEmployeeManagementSystem.getContentPane().add(panel);
		
		JLabel label = new JLabel(MyMethods.getGlobUsername());
		label.setBounds(98, 11, 89, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Username:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(25, 11, 67, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("First name:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(25, 36, 67, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel(MyMethods.getGlobFirstname());
		label_3.setBounds(98, 36, 89, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel((String) null);
		label_4.setBounds(98, 61, 89, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Last name:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(25, 61, 67, 14);
		panel.add(label_5);
		
		JLabel label_10 = new JLabel((String) null);
		label_10.setBounds(98, 11, 89, 14);
		panel.add(label_10);
		
		JLabel label_11 = new JLabel((String) null);
		label_11.setBounds(98, 38, 89, 14);
		panel.add(label_11);
		String hoursWorked = Integer.toString(MyMethods.getGlobHoursWorked());
		JLabel label_12 = new JLabel(MyMethods.getGlobLastname());
		label_12.setBounds(98, 63, 89, 14);
		panel.add(label_12);
		double pay = MyMethods.getGlobHoursWorked() * MyMethods.getGlobSalary();
		String salary = Double.toString(pay);
		
		JButton btnReadMessagesFrom = new JButton("READ MESSAGES FROM EMPLOYEES");
		btnReadMessagesFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyMethods mthds= new MyMethods();
				mthds.readMessage();
			}
		});
		btnReadMessagesFrom.setBounds(355, 317, 271, 25);
		frmEmployeeManagementSystem.getContentPane().add(btnReadMessagesFrom);
		
		JButton btnNewButton_3 = new JButton("DELETE ALL READ MESSAGES");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyMethods mthds=new MyMethods();
				
				for(int i=2;i>1;i++ ){
					String choice=JOptionPane.showInputDialog("Are you sure you want to delete all messages?(YES/NO)");
					if (choice.equals("yes")||choice.equals("YES")||choice.equals("Yes")){
						mthds.deleteMessage();
						break;
					}else if(choice.equals("no")||choice.equals("NO")||choice.equals("No")){
						break;
		
					}
					else{
						JOptionPane.showMessageDialog(null, "Please enter a valid choice.");				
					}
				}
			}
		});
		btnNewButton_3.setBounds(355, 269, 271, 25);
		frmEmployeeManagementSystem.getContentPane().add(btnNewButton_3);
		
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

	public JFrame getFrmEmployeeManagementSystem() {
		return frmEmployeeManagementSystem;
	}

	public void setFrmEmployeeManagementSystem(JFrame frmEmployeeManagementSystem) {
		this.frmEmployeeManagementSystem = frmEmployeeManagementSystem;
	}
}