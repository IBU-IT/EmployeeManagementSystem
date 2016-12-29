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
import javax.swing.SwingConstants;

public class NewPassForUsers  {

	private JFrame NewPass;
	private JTextField PassInput;
	private JButton btnExit;

	/**
	 * Launch the application.
	 */
	public static void UserInterface() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPassForUsers window = new NewPassForUsers();
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
	public NewPassForUsers(){
		initialize();

	}


	private void initialize() {
		setNewPass(new JFrame());
		getNewPass().setVisible(true);
		getNewPass().setResizable(false);
		getNewPass().setIconImage(
				Toolkit.getDefaultToolkit().getImage(MainWindowAdmin.class.getResource("/images/burc.jpg")));
		getNewPass().setTitle("Employee Management System");
		getNewPass().setBounds(100, 100, 453, 268);
		getNewPass().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		NewPass.getContentPane().setLayout(null);
		
		PassInput = new JTextField();
		PassInput.setBounds(223, 87, 116, 22);
		NewPass.getContentPane().add(PassInput);
		PassInput.setColumns(10);
		
		JButton btnChangePass = new JButton("Set new password");
		btnChangePass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				MyMethods mthds = new MyMethods();
				mthds.changePass(MyMethods.getGlobUsername(),PassInput.getText());
				JOptionPane.showMessageDialog(null,"Your new password is "+PassInput.getText());
				getNewPass().setVisible(false);
			}
		});
		btnChangePass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnChangePass.setBounds(132, 139, 173, 25);
		NewPass.getContentPane().add(btnChangePass);
		
		JLabel lblNewPassword = new JLabel("New password:");
		lblNewPassword.setHorizontalAlignment(SwingConstants.RIGHT);
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
