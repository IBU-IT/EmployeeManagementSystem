package turshija;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;
import java.awt.Button;
import java.awt.TextField;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class LoginForm2 {
	String username = "a";
	String password = "s";

	private JFrame frmEmployeeManagementSystem;
	private JTextField userInput;
	private JPasswordField passInput;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm2 window = new LoginForm2();
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
	public LoginForm2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeeManagementSystem = new JFrame();
		frmEmployeeManagementSystem.getContentPane().addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
			}
		});
		frmEmployeeManagementSystem.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmEmployeeManagementSystem.setTitle("Employee Management System - LOGIN");
		frmEmployeeManagementSystem.getContentPane().setBackground(Color.WHITE);
		frmEmployeeManagementSystem.setResizable(false);
		frmEmployeeManagementSystem.setBounds(100, 100, 477, 338);
		frmEmployeeManagementSystem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		userInput = new JTextField();
		userInput.setColumns(10);
		
		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setEditable(false);
		txtpnUsername.setText("Username:");
		
		passInput = new JPasswordField();
		passInput.setColumns(10);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setEditable(false);
		txtpnPassword.setText("Password:");
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String passText = new String(passInput.getPassword());
				if (userInput.getText().equals(username)){
					if (passText.equals(password)){

						
						JOptionPane.showMessageDialog(null, "You have logged in successfully.");
						MainWindow nw = new MainWindow();
						nw.UserInterface();
						frmEmployeeManagementSystem.setVisible(false); 
						
						
						
					}else {
						JOptionPane.showMessageDialog(null, "The password you have entered is incorrect. \nPlease try again.");
					}
				}else {
					JOptionPane.showMessageDialog(null, "The username you have entered is incorrect. \nPlease try again.");
				}
			}

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, getPassInput());
			}
		});
		
		btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
				
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmEmployeeManagementSystem.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(156)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnLogin)
							.addGap(18)
							.addComponent(btnExit, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(txtpnUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtpnPassword, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(passInput, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(userInput, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
							.addGap(4)))
					.addGap(171))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(170, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(userInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtpnUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtpnPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnLogin)
						.addComponent(btnExit))
					.addGap(40))
		);
		frmEmployeeManagementSystem.getContentPane().setLayout(groupLayout);
	}
	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

	public JPasswordField getPassInput() {
		return passInput;
	}
	public boolean getFrmEmployeeManagementSystemContentPaneVisible() {
		return frmEmployeeManagementSystem.getContentPane().isVisible();
	}
	public void setFrmEmployeeManagementSystemContentPaneVisible(boolean visible) {
		frmEmployeeManagementSystem.getContentPane().setVisible(visible);
	}
}
