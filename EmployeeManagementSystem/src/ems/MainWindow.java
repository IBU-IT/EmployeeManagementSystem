package ems;

import java.awt.EventQueue;
import org.apache.commons.io.FilenameUtils;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

public class MainWindow {
	private JLabel lblClock;
	private JFrame frmEmployeeManagementSystem;

	/**
	 * Launch the application.
	 */
	public static void UserInterface() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					MainWindow window = new MainWindow();
					window.frmEmployeeManagementSystem.setVisible(true);
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
	public MainWindow() {
		initialize();
		clock();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeeManagementSystem = new JFrame();
		
		frmEmployeeManagementSystem.setResizable(false);
		frmEmployeeManagementSystem.getContentPane().setBackground(Color.WHITE);
		frmEmployeeManagementSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/images/burc.jpg")));
		frmEmployeeManagementSystem.setTitle("Employee Management System");
		frmEmployeeManagementSystem.setBounds(100, 100, 685, 436);
		frmEmployeeManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeeManagementSystem.getContentPane().setLayout(null);
		frmEmployeeManagementSystem.setLocationRelativeTo(null);
		frmEmployeeManagementSystem.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(30, 30, 212, 85);
		frmEmployeeManagementSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnArrivalTime = new JTextPane();
		txtpnArrivalTime.setEditable(false);
		txtpnArrivalTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnArrivalTime.setBounds(10, 0, 136, 27);
		txtpnArrivalTime.setOpaque(false);
		txtpnArrivalTime.setToolTipText("");
		txtpnArrivalTime.setText("ARRIVAL TIME:");
		panel.add(txtpnArrivalTime);
		
		JComboBox arrTime1 = new JComboBox();
		arrTime1.setToolTipText("");
		arrTime1.setBounds(32, 38, 45, 20);
		panel.add(arrTime1);
		arrTime1.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		arrTime1.setSelectedIndex(0);
		
		JTextPane txtpnHour = new JTextPane();
		txtpnHour.setToolTipText("");
		txtpnHour.setText("HH");
		txtpnHour.setOpaque(false);
		txtpnHour.setBounds(10, 38, 20, 20);
		panel.add(txtpnHour);
		
		JComboBox arrTime2 = new JComboBox();
		arrTime2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
		arrTime2.setBounds(109, 38, 45, 20);
		panel.add(arrTime2);
		
		JTextPane txtpnMm = new JTextPane();
		txtpnMm.setToolTipText("");
		txtpnMm.setText("MM");
		txtpnMm.setOpaque(false);
		txtpnMm.setBounds(85, 38, 22, 20);
		panel.add(txtpnMm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setLayout(null);
		panel_1.setBounds(30, 126, 212, 85);
		frmEmployeeManagementSystem.getContentPane().add(panel_1);
		
		JTextPane txtpnLeavingTime = new JTextPane();
		txtpnLeavingTime.setEditable(false);
		txtpnLeavingTime.setToolTipText("");
		txtpnLeavingTime.setText("LEAVING TIME:");
		txtpnLeavingTime.setOpaque(false);
		txtpnLeavingTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnLeavingTime.setBounds(10, 0, 136, 27);
		panel_1.add(txtpnLeavingTime);
		
		JComboBox leavTime1 = new JComboBox();
		leavTime1.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		leavTime1.setBounds(32, 38, 45, 20);
		panel_1.add(leavTime1);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setToolTipText("");
		textPane_1.setText("HH");
		textPane_1.setOpaque(false);
		textPane_1.setBounds(10, 38, 20, 20);
		panel_1.add(textPane_1);
		
		JComboBox leavTime2 = new JComboBox();
		leavTime2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
		leavTime2.setBounds(109, 38, 45, 20);
		panel_1.add(leavTime2);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setToolTipText("");
		textPane_2.setText("MM");
		textPane_2.setOpaque(false);
		textPane_2.setBounds(85, 38, 22, 20);
		panel_1.add(textPane_2);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(580, 373, 89, 23);
		frmEmployeeManagementSystem.getContentPane().add(btnExit);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmEmployeeManagementSystem.setVisible(false);
				LoginKlasa frame = new LoginKlasa();
				frame.setVisible(true);
				
			}
			
		});
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnLogout.setBounds(481, 373, 89, 23);
		frmEmployeeManagementSystem.getContentPane().add(btnLogout);
		
		JButton btnStats = new JButton("STATS");
		btnStats.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStats.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "You worked "+MyMethods.getGlobHW()+" hours this month.");
			}
		});
		btnStats.setBounds(382, 373, 89, 23);
		frmEmployeeManagementSystem.getContentPane().add(btnStats);
		
		JButton btnSubmit = new JButton("--->SUBMIT<---");
		btnSubmit.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
		});
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String arrHour = (String)arrTime1.getSelectedItem();
				int hour1 = Integer.parseInt(arrHour);
				String arrMin = (String)arrTime2.getSelectedItem();
				int min1 = Integer.parseInt(arrMin);
				String leaveHour = (String)leavTime1.getSelectedItem();
				int hour2 = Integer.parseInt(leaveHour);
				String leaveMin = (String)leavTime2.getSelectedItem();
				int min2 = Integer.parseInt(leaveMin);
				int result = (((hour2 * 60) + min2) - ((hour1 * 60) + min1));
				int resultMin = result % 60;
				int resultHour = (result / 60)+MyMethods.getGlobHW();
				MyMethods mthds = new MyMethods();
				MyMethods.setGlobHW(resultHour);
				mthds.setHoursDB(resultHour);
				
				//JOptionPane.showMessageDialog(null, "You worked "+resultHour+" hours today.");
			}
		});
		btnSubmit.setVerifyInputWhenFocusTarget(false);
		btnSubmit.setFocusPainted(false);
		btnSubmit.setBounds(30, 222, 212, 55);
		frmEmployeeManagementSystem.getContentPane().add(btnSubmit);
		
		JLabel lblEmployeeWindow = new JLabel("Employee Window");
		lblEmployeeWindow.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeWindow.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmployeeWindow.setBounds(414, 11, 255, 49);
		frmEmployeeManagementSystem.getContentPane().add(lblEmployeeWindow);
		
		lblClock = new JLabel("Date&Time");
		lblClock.setBounds(45, 372, 197, 16);
		frmEmployeeManagementSystem.getContentPane().add(lblClock);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(446, 67, 197, 144);
		frmEmployeeManagementSystem.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel(MyMethods.getGlobUsername());
		label.setBounds(98, 11, 89, 14);
		panel_2.add(label);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(25, 11, 67, 14);
		panel_2.add(lblUsername);
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setBounds(25, 36, 67, 14);
		panel_2.add(lblFirstName);
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel label_1 = new JLabel(MyMethods.getGlobFirstname());
		label_1.setBounds(98, 36, 89, 14);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel(MyMethods.getGlobLastname());
		label_2.setBounds(98, 61, 89, 14);
		panel_2.add(label_2);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setBounds(25, 61, 67, 14);
		panel_2.add(lblLastName);
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JLabel lblHoursWorked = new JLabel("Worked:");
		lblHoursWorked.setBounds(25, 86, 67, 14);
		panel_2.add(lblHoursWorked);
		lblHoursWorked.setHorizontalAlignment(SwingConstants.RIGHT);
		String hoursWorked = Integer.toString(MyMethods.getGlobHoursWorked());
		JLabel label_3 = new JLabel(hoursWorked);
		label_3.setBounds(98, 86, 89, 14);
		panel_2.add(label_3);
		double pay = MyMethods.getGlobHoursWorked() * MyMethods.getGlobSalary();
		String salary = Double.toString(pay);
		JLabel label_4 = new JLabel(salary);
		label_4.setBounds(98, 111, 89, 14);
		panel_2.add(label_4);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setBounds(25, 111, 67, 14);
		panel_2.add(lblSalary);
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JButton btnNewButton = new JButton("Change Password");
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				NewPassForUsers window = new NewPassForUsers();
			}
		});
		btnNewButton.setBounds(446, 227, 197, 23);
		frmEmployeeManagementSystem.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SEND A MESSAGE TO ADMIN");
		btnNewButton_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Messages mess= new Messages ();
			mess.Messages();
			}
		});
		btnNewButton_1.setBounds(30, 290, 212, 49);
		frmEmployeeManagementSystem.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MainWindow.class.getResource("/images/Image123.png")));
		lblNewLabel.setBounds(0, 0, 679, 407);
		frmEmployeeManagementSystem.getContentPane().add(lblNewLabel);
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		
	}
}