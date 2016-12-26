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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainWindowAdmin {

	private JFrame frmEmployeeManagementSystem;

	/**
	 * Launch the application.
	 */
	public static void UserInterface() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindowAdmin window = new MainWindowAdmin();
					window.frmEmployeeManagementSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindowAdmin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeeManagementSystem = new JFrame();
		frmEmployeeManagementSystem.setVisible(true);
		frmEmployeeManagementSystem.setResizable(false);
		frmEmployeeManagementSystem.getContentPane().setBackground(Color.WHITE);
		frmEmployeeManagementSystem.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindowAdmin.class.getResource("/images/burc.jpg")));
		frmEmployeeManagementSystem.setTitle("Employee Management System");
		frmEmployeeManagementSystem.setBounds(100, 100, 685, 436);
		frmEmployeeManagementSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployeeManagementSystem.getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(580, 373, 89, 23);
		frmEmployeeManagementSystem.getContentPane().add(btnExit);
		
		JButton btnLogout = new JButton("LOGOUT");
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
		
		JLabel lblAdminWindow = new JLabel("Admin Window");
		lblAdminWindow.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAdminWindow.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminWindow.setBounds(356, 53, 255, 49);
		frmEmployeeManagementSystem.getContentPane().add(lblAdminWindow);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		JLabel label = new JLabel(dateFormat.format(date));
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(23, 373, 167, 23);
		frmEmployeeManagementSystem.getContentPane().add(label);
		
		JButton btnCheck = new JButton("CHECK");
		btnCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkHours window = new checkHours();
				window.frmEmsCheck.setVisible(true);
				
			}
		});
		btnCheck.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCheck.setBounds(45, 135, 212, 49);
		frmEmployeeManagementSystem.getContentPane().add(btnCheck);
		
		
	}
}