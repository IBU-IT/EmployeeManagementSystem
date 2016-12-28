package ems;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class checkHours {
//test3
	JFrame frmEmsCheck;
	private JTextField usernameInput;

	/**
	 * Launch the application.
	 */
	public static void UserFullReport() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkHours window = new checkHours();
					window.frmEmsCheck.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public checkHours() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmsCheck = new JFrame();
		frmEmsCheck.setType(Type.POPUP);
		frmEmsCheck.setResizable(false);
		frmEmsCheck.setTitle("User full report");
		frmEmsCheck.setBounds(100, 100, 450, 300);
		frmEmsCheck.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frmEmsCheck.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		usernameInput = new JTextField();
		
		usernameInput.setHorizontalAlignment(SwingConstants.LEFT);
		usernameInput.setBounds(198, 83, 86, 20);
		usernameInput.setColumns(10);
		panel.add(usernameInput);
		
		JLabel label = new JLabel("Username");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(131, 86, 70, 14);
		panel.add(label);
		
		JButton btnCheck = new JButton("CHECK");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCheck.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String usernameCheck = usernameInput.getText();
				MyMethods mthds = new MyMethods();
				mthds.checkEmployee(usernameCheck);
				UserReport UserReport = new UserReport();
				UserReport.UserReport.setVisible(true);
			}
		});
		btnCheck.setBounds(131, 114, 153, 49);
		panel.add(btnCheck);
	}

}
