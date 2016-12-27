package ems;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DeleteUser {

	private JFrame frame;
	private JTextField usernameDelete;
	private JFrame DeleteUser;

	/**
	 * Launch the application.
	 */
	public static void UserInterface() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUser window3 = new DeleteUser();
					window3.getDeleteUser().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DeleteUser() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		usernameDelete = new JTextField();
		usernameDelete.setBounds(216, 89, 86, 20);
		frame.getContentPane().add(usernameDelete);
		usernameDelete.setColumns(10);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setBounds(141, 92, 65, 14);
		frame.getContentPane().add(lblUsername);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MyMethods mthds = new MyMethods();
				
				mthds.deleteEmployee(usernameDelete.getText());
				frame.setVisible(false);
				JOptionPane.showMessageDialog(null, "The "+usernameDelete.getText()+" user has been deleted");
				
			}
		});
		btnDelete.setBounds(192, 120, 89, 23);
		frame.getContentPane().add(btnDelete);
	}
	public JFrame getDeleteUser() {
		return DeleteUser;
	}

	public void setDeleteUser(JFrame DeleteUser) {
		this.DeleteUser = DeleteUser;
		DeleteUser.getContentPane().setBackground(Color.WHITE);
	}
}
