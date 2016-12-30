package ems;
// asdfghjk
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
		
		usernameDelete = new JTextField();
		usernameDelete.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER){

					MyMethods mthds = new MyMethods();
					
					mthds.deleteEmployee(usernameDelete.getText());
					frame.setVisible(false);
					
					
				}
			}
		});
		usernameDelete.setBounds(220,92, 86, 20);
		frame.getContentPane().add(usernameDelete);
		usernameDelete.setColumns(10);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(143, 92, 65, 14);
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
		btnDelete.setBounds(130, 120, 89, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExit.setBounds(229, 120, 89, 23);
		frame.getContentPane().add(btnExit);
	}
	public JFrame getDeleteUser() {
		return DeleteUser;
	}

	public void setDeleteUser(JFrame DeleteUser) {
		this.DeleteUser = DeleteUser;
		DeleteUser.getContentPane().setBackground(Color.WHITE);
	}
}
