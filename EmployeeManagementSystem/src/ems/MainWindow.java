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

public class MainWindow {

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

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
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
		
		JPanel panel = new JPanel();
		panel.setBounds(30, 30, 212, 85);
		frmEmployeeManagementSystem.getContentPane().add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnArrivalTime = new JTextPane();
		txtpnArrivalTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnArrivalTime.setBounds(10, 0, 136, 27);
		txtpnArrivalTime.setOpaque(false);
		txtpnArrivalTime.setToolTipText("");
		txtpnArrivalTime.setText("ARRIVAL TIME:");
		panel.add(txtpnArrivalTime);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(32, 38, 45, 20);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		
		JTextPane txtpnHour = new JTextPane();
		txtpnHour.setToolTipText("");
		txtpnHour.setText("HH");
		txtpnHour.setOpaque(false);
		txtpnHour.setBounds(10, 38, 20, 20);
		panel.add(txtpnHour);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "226", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
		comboBox_1.setBounds(109, 38, 45, 20);
		panel.add(comboBox_1);
		
		JTextPane txtpnMm = new JTextPane();
		txtpnMm.setToolTipText("");
		txtpnMm.setText("MM");
		txtpnMm.setOpaque(false);
		txtpnMm.setBounds(85, 38, 22, 20);
		panel.add(txtpnMm);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(30, 126, 212, 85);
		frmEmployeeManagementSystem.getContentPane().add(panel_1);
		
		JTextPane txtpnLeavingTime = new JTextPane();
		txtpnLeavingTime.setToolTipText("");
		txtpnLeavingTime.setText("LEAVING TIME:");
		txtpnLeavingTime.setOpaque(false);
		txtpnLeavingTime.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnLeavingTime.setBounds(10, 0, 136, 27);
		panel_1.add(txtpnLeavingTime);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		comboBox_2.setBounds(32, 38, 45, 20);
		panel_1.add(comboBox_2);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setToolTipText("");
		textPane_1.setText("HH");
		textPane_1.setOpaque(false);
		textPane_1.setBounds(10, 38, 20, 20);
		panel_1.add(textPane_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "226", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60"}));
		comboBox_3.setBounds(109, 38, 45, 20);
		panel_1.add(comboBox_3);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setToolTipText("");
		textPane_2.setText("MM");
		textPane_2.setOpaque(false);
		textPane_2.setBounds(85, 38, 22, 20);
		panel_1.add(textPane_2);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setBounds(580, 373, 89, 23);
		frmEmployeeManagementSystem.getContentPane().add(btnExit);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setBounds(481, 373, 89, 23);
		frmEmployeeManagementSystem.getContentPane().add(btnLogout);
		
		JButton btnStats = new JButton("STATS");
		btnStats.setBounds(382, 373, 89, 23);
		frmEmployeeManagementSystem.getContentPane().add(btnStats);
		
		JButton btnSubmit = new JButton("--->SUBMIT<---");
		btnSubmit.setVerifyInputWhenFocusTarget(false);
		btnSubmit.setFocusPainted(false);
		btnSubmit.setBounds(30, 222, 212, 55);
		frmEmployeeManagementSystem.getContentPane().add(btnSubmit);
		
		
	}
}
