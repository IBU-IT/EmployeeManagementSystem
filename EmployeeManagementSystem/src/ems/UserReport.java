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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		getUserReport().setLocationRelativeTo(null);
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
		lblUsername.setBounds(40, 25, 75, 16);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		UserReport.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(40, 54, 75, 16);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 13));
		UserReport.getContentPane().add(lblPassword);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setBounds(40, 83, 75, 16);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 13));
		UserReport.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setBounds(40, 112, 75, 16);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
		UserReport.getContentPane().add(lblLastName);
		
		JLabel lblHoursWorkedThis = new JLabel("Hours worked this month");
		lblHoursWorkedThis.setBounds(40, 141, 180, 16);
		lblHoursWorkedThis.setFont(new Font("Tahoma", Font.BOLD, 13));
		UserReport.getContentPane().add(lblHoursWorkedThis);
		
		JLabel lblTypeId = new JLabel("Type ID:");
		lblTypeId.setBounds(40, 170, 75, 16);
		lblTypeId.setFont(new Font("Tahoma", Font.BOLD, 13));
		UserReport.getContentPane().add(lblTypeId);
		
		JPanel panel = new JPanel();
		panel.setBounds(137, 25, 151, 16);
		UserReport.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblusername = new JLabel(MyMethods.getGlobUsername());
		lblusername.setHorizontalAlignment(SwingConstants.CENTER);
		lblusername.setBounds(0, 0, 151, 16);
		panel.add(lblusername);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(214, 141, 69, 16);
		UserReport.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		String hwConv = Integer.toString(MyMethods.getGlobHoursWorked());
		JLabel lblhours = new JLabel(hwConv);
		lblhours.setHorizontalAlignment(SwingConstants.CENTER);
		lblhours.setBounds(0, 0, 79, 16);
		panel_4.add(lblhours);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(137, 112, 151, 16);
		UserReport.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbllastname = new JLabel(MyMethods.getGlobLastname());
		lbllastname.setHorizontalAlignment(SwingConstants.CENTER);
		lbllastname.setBounds(0, 0, 151, 16);
		panel_1.add(lbllastname);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(137, 54, 151, 16);
		UserReport.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblpassword = new JLabel(MyMethods.getGlobPassword());
		lblpassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblpassword.setBounds(0, 0, 151, 16);
		panel_2.add(lblpassword);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(137, 83, 151, 16);
		UserReport.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblfirstname = new JLabel(MyMethods.getGlobFirstname());
		lblfirstname.setHorizontalAlignment(SwingConstants.CENTER);
		lblfirstname.setBounds(0, 0, 151, 16);
		panel_3.add(lblfirstname);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(135, 170, 153, 16);
		UserReport.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		String type = "";
		if (MyMethods.getGlobType().equals("1")){
			type = "Admin";
		}
		else if (MyMethods.getGlobType().equals("2")) {
			type = "Employee";
		}
		JLabel lbltypeID = new JLabel(type);
		lbltypeID.setHorizontalAlignment(SwingConstants.CENTER);
		lbltypeID.setBounds(0, 0, 153, 16);
		panel_5.add(lbltypeID);
		
		JButton btnExit = new JButton("OK");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExit.setBounds(335, 227, 89, 23);
		btnExit.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					getUserReport().setVisible(false);
					}
			}
		});
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getUserReport().setVisible(false);
				
			}
		});
		UserReport.getContentPane().add(btnExit);
		
		JLabel lblSalary = new JLabel("Salary per hour:");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSalary.setBounds(40, 197, 75, 16);
		UserReport.getContentPane().add(lblSalary);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(135, 197, 153, 16);
		UserReport.getContentPane().add(panel_6);
		String pay = Double.toString(MyMethods.getGlobSalary());
		JLabel label_2 = new JLabel(pay);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(0, 0, 153, 16);
		panel_6.add(label_2);
		UserReport.setSize( 450, 300);
		UserReport.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

}
	public JFrame getUserReport() {
		return UserReport;
	}

	public void setUserReport(JFrame UserReport) {
		this.UserReport = UserReport;
	}
}