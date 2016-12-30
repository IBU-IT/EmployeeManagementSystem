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
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewPass {

	private JFrame NewPass;
	private JTextField PassInput;
	private JTextField UsernameInput;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void UserInterface() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPass window = new NewPass();
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
	public NewPass() {
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
		PassInput = new JTextField();
		PassInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					MyMethods mthds = new MyMethods();
					mthds.changePass(UsernameInput.getText(), PassInput.getText());
					getNewPass().setVisible(false);
				}
			}
		});
		PassInput.setBounds(223, 87, 116, 22);
		NewPass.getContentPane().add(PassInput);
		PassInput.setColumns(10);

		JButton btnChangePass = new JButton("Set new password");
		btnChangePass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				MyMethods mthds = new MyMethods();
				mthds.changePass(UsernameInput.getText(), PassInput.getText());
				
				getNewPass().setVisible(false);
			}
		});
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChangePass.setBounds(132, 139, 173, 25);
		NewPass.getContentPane().add(btnChangePass);

		UsernameInput = new JTextField();
		UsernameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					MyMethods mthds = new MyMethods();
					mthds.changePass(UsernameInput.getText(), PassInput.getText());
					getNewPass().setVisible(false);
					
				}
			}
		});
		UsernameInput.setBounds(223, 52, 116, 22);
		NewPass.getContentPane().add(UsernameInput);
		UsernameInput.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(104, 55, 83, 16);
		NewPass.getContentPane().add(lblUsername);

		JLabel lblNewPassword = new JLabel("New password");
		lblNewPassword.setBounds(104, 90, 107, 16);
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
	}

	public JFrame getNewPass() {
		return NewPass;
	}

	public void setNewPass(JFrame NewPass) {
		this.NewPass = NewPass;
		NewPass.getContentPane().setBackground(Color.WHITE);
	}
}
