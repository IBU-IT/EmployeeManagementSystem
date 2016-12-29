package ems;
//test
import java.awt.EventQueue;
import net.proteanit.sql.DbUtils;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserReport {

	JFrame UserReport;

	/**
	 * Launch the application.
	 */
	public static void UserInterface() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserReport window = new UserReport();
					window.getUserReport().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public UserReport() {
		initialize();
		getUserReport().setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		UserReport = new JFrame();
		UserReport.setTitle("User Report");
		UserReport.getContentPane().setBackground(Color.WHITE);
		UserReport.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBounds(41, 59, 75, 16);
		UserReport.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPassword.setBounds(41, 88, 75, 16);
		UserReport.getContentPane().add(lblPassword);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFirstName.setBounds(41, 117, 75, 16);
		UserReport.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblLastName.setBounds(41, 146, 75, 16);
		UserReport.getContentPane().add(lblLastName);
		
		JLabel lblHoursWorkedThis = new JLabel("Hours worked this month");
		lblHoursWorkedThis.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHoursWorkedThis.setBounds(41, 175, 180, 16);
		UserReport.getContentPane().add(lblHoursWorkedThis);
		
		JLabel lblTypeId = new JLabel("Type ID:");
		lblTypeId.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTypeId.setBounds(41, 204, 75, 16);
		UserReport.getContentPane().add(lblTypeId);
		
		JPanel panel = new JPanel();
		panel.setBounds(138, 59, 151, 16);
		UserReport.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblusername = new JLabel(MyMethods.getGlobUsername());
		lblusername.setHorizontalAlignment(SwingConstants.CENTER);
		lblusername.setBounds(0, 0, 151, 16);
		panel.add(lblusername);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(215, 175, 69, 16);
		UserReport.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblhours = new JLabel("0 ");
		lblhours.setHorizontalAlignment(SwingConstants.CENTER);
		lblhours.setBounds(0, 0, 79, 16);
		panel_4.add(lblhours);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(138, 146, 151, 16);
		UserReport.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbllastname = new JLabel(MyMethods.getGlobLastname());
		lbllastname.setHorizontalAlignment(SwingConstants.CENTER);
		lbllastname.setBounds(0, 0, 151, 16);
		panel_1.add(lbllastname);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(138, 88, 151, 16);
		UserReport.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblpassword = new JLabel(MyMethods.getGlobPassword());
		lblpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblpassword.setBounds(0, 0, 151, 16);
		panel_2.add(lblpassword);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(138, 117, 151, 16);
		UserReport.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblfirstname = new JLabel(MyMethods.getGlobFirstname());
		lblfirstname.setHorizontalAlignment(SwingConstants.CENTER);
		lblfirstname.setBounds(0, 0, 151, 16);
		panel_3.add(lblfirstname);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(136, 204, 153, 16);
		UserReport.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lbltypeID = new JLabel(MyMethods.getGlobType());
		lbltypeID.setHorizontalAlignment(SwingConstants.CENTER);
		lbltypeID.setBounds(0, 0, 153, 16);
		panel_5.add(lbltypeID);
		
		JButton btnExit = new JButton("OK");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getUserReport().setVisible(false);
				
			}
		});
		btnExit.setBounds(335, 227, 89, 23);
		UserReport.getContentPane().add(btnExit);
		UserReport.setBounds(100, 100, 450, 300);
		UserReport.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

}
	public JFrame getUserReport() {
		return UserReport;
	}

	public void setUserReport(JFrame UserReport) {
		this.UserReport = UserReport;
	}
}