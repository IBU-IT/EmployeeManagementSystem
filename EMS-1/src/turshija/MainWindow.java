package turshija;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {
	

	private JFrame frmEmployeeManagementSystem;

	/**
	 * Launch the application.
	 */
	public static void UserInterface() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployeeManagementSystem = new JFrame();
		frmEmployeeManagementSystem.setTitle("Employee Management System");
		frmEmployeeManagementSystem.setBounds(100, 100, 450, 300);
		frmEmployeeManagementSystem.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEmployeeManagementSystem.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmEmployeeManagementSystem.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(1724, 945, 107, 61);
		frmEmployeeManagementSystem.getContentPane().add(btnNewButton);
		
	}

	public boolean getFrameContentPaneVisible() {
		return frmEmployeeManagementSystem.getContentPane().isVisible();
	}
	public void setFrameContentPaneVisible(boolean visible) {
		frmEmployeeManagementSystem.getContentPane().setVisible(visible);
	}
}
