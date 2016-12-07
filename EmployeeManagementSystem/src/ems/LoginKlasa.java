package ems;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import ems.MainWindow;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginKlasa extends JFrame {

	private JPanel contentPane;
	private JTextField userInput;
	private JPasswordField passInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginKlasa frame = new LoginKlasa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginKlasa() {
		setVisible(true);
		setTitle("Employee Management System - Login");
		String username = "a";
		String password = "s";
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton login = new JButton("LOGIN");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				String passText = new String(passInput.getPassword());
				if (userInput.getText().equals(username)) {
					if (passText.equals(password)) {

						JOptionPane.showMessageDialog(null, "You have logged in successfully.");
						MainWindow nw = new MainWindow();
						nw.UserInterface();
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null,
								"The password you have entered is incorrect. \nPlease try again.");
					}
				} else {
					JOptionPane.showMessageDialog(null,
							"The username you have entered is incorrect. \nPlease try again.");
				}
			}

		});
		login.setBounds(132, 260, 97, 25);
		contentPane.add(login);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(114, 202, 89, 16);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(114, 231, 89, 16);
		contentPane.add(lblPassword);

		userInput = new JTextField();
		userInput.setBounds(203, 202, 131, 22);
		contentPane.add(userInput);
		userInput.setColumns(10);

		passInput = new JPasswordField();
		passInput.setColumns(10);
		passInput.setBounds(203, 231, 131, 22);
		contentPane.add(passInput);

		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "http://www.ibu.edu.ba/bs/");
			}
		});
		label.setIcon(new ImageIcon(LoginKlasa.class.getResource("/images/burc.jpg")));
		label.setBounds(134, 13, 180, 156);
		contentPane.add(label);

		JLabel lblClickLogoFor = new JLabel("Click logo for more info");
		lblClickLogoFor.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblClickLogoFor.setBounds(167, 170, 133, 16);
		contentPane.add(lblClickLogoFor);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(237, 261, 97, 25);
		contentPane.add(btnExit);
	}
}
