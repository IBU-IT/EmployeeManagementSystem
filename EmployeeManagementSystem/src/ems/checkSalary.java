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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class checkSalary {

	JFrame frmEmsCheck;
	private JTextField usernameInput;

	/**
	 * Launch the application.
	 */
	public static void UserFullReport() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					checkSalary window = new checkSalary();
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
	public checkSalary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmsCheck = new JFrame();
		frmEmsCheck.setType(Type.POPUP);
		frmEmsCheck.setResizable(false);
		frmEmsCheck.setSize(450, 300);
		frmEmsCheck.setTitle("Check salary - EMS");
		frmEmsCheck.setLocationRelativeTo(null);
		frmEmsCheck.setVisible(true);

		frmEmsCheck.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel();
		frmEmsCheck.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		usernameInput = new JTextField();
		usernameInput.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {

					String usernameCheck = usernameInput.getText();
					MyMethods mthds = new MyMethods();
					JOptionPane.showMessageDialog(null, "The salary for employee " + usernameCheck + " is "
							+ mthds.calculateSalary(usernameCheck) + ".");

					frmEmsCheck.setVisible(false);
				}
			}
		});

		usernameInput.setHorizontalAlignment(SwingConstants.LEFT);
		usernameInput.setBounds(208, 83, 86, 20);
		usernameInput.setColumns(10);
		panel.add(usernameInput);

		JLabel label = new JLabel("Username");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setBounds(141, 86, 70, 14);
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
				JOptionPane.showMessageDialog(null, "The salary for employee " + usernameCheck + " is "
						+ mthds.calculateSalary(usernameCheck) + ".");

				frmEmsCheck.setVisible(false);
			}
		});
		btnCheck.setBounds(141, 114, 153, 23);
		panel.add(btnCheck);

		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEmsCheck.setVisible(false);

			}
		});
		btnNewButton.setBounds(141, 148, 153, 23);
		panel.add(btnNewButton);
	}

}
