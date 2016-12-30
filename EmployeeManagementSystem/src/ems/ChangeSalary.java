package ems;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ChangeSalary {

	private JFrame NewPass;
	private JTextField newSalaryInput;
	private JButton btnExit;
	private JTextField usernameInput;

	/**
	 * Launch the application.
	 */
	public static void UserInterface() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangeSalary window = new ChangeSalary();
					window.getNewPass().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void setVisible(boolean b) {
		// TODO Auto-generated method stub

	}

	/**
	 * Create the frame.
	 */
	public ChangeSalary() {
		initialize();

	}

	private void initialize() {
		setNewPass(new JFrame());

		getNewPass().setResizable(false);
		getNewPass().setIconImage(
				Toolkit.getDefaultToolkit().getImage(MainWindowAdmin.class.getResource("/images/burc.jpg")));
		getNewPass().setTitle("Employee Management System");
		getNewPass().setSize(453, 268);
		getNewPass().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		NewPass.getContentPane().setLayout(null);
		getNewPass().setLocationRelativeTo(null);
		getNewPass().setVisible(true);
		newSalaryInput = new JTextField();
		newSalaryInput.setBounds(199, 86, 116, 22);
		NewPass.getContentPane().add(newSalaryInput);
		newSalaryInput.setColumns(10);

		JButton btnChangePass = new JButton("Set new salary");
		btnChangePass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String username = usernameInput.getText();
				double salary = Double.parseDouble(newSalaryInput.getText());
				MyMethods mthds = new MyMethods();
				mthds.changeSalary(username, salary);
				JOptionPane.showMessageDialog(null, "Salary for employee "+username+" is changed to "+salary+".");
				getNewPass().setVisible(false);
			}
		});
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChangePass.setBounds(132, 139, 173, 25);
		NewPass.getContentPane().add(btnChangePass);

		JLabel lblNewPassword = new JLabel("New Salary:");
		lblNewPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewPassword.setBounds(80, 89, 107, 16);
		NewPass.getContentPane().add(lblNewPassword);

		btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getNewPass().setVisible(false);
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setBounds(132, 175, 173, 25);
		NewPass.getContentPane().add(btnExit);
		
		usernameInput = new JTextField();
		usernameInput.setColumns(10);
		usernameInput.setBounds(199, 53, 116, 22);
		NewPass.getContentPane().add(usernameInput);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsername.setBounds(80, 56, 107, 16);
		NewPass.getContentPane().add(lblUsername);
	}

	public JFrame getNewPass() {
		return NewPass;
	}

	public void setNewPass(JFrame NewPass) {
		this.NewPass = NewPass;
		NewPass.getContentPane().setBackground(Color.WHITE);
	}
}
