package ems;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

public class Messages extends JFrame {

	private JPanel contentPane;
	private JTextArea message;

	/**
	 * Launch the application.
	 */
	public void Messages () {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Messages frame = new Messages();
					frame.setLocationRelativeTo(null);
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
	public Messages() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize( 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		message = new JTextArea();
		
		
		message.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER){
					try {
						
						Connection myConn = DriverManager.getConnection(MyMethods.DB_URL, MyMethods.USER, MyMethods.PASS);
						Statement myStmt = myConn.createStatement();
						int result = myStmt.executeUpdate("INSERT INTO messages (username,message ) "
								+ "VALUES ('"+MyMethods.getGlobUsername()+"','"+ message.getText()+"')");		
						JOptionPane.showMessageDialog(null, "Your message has been sent");
						setVisible(false);
						myConn.close();
					} catch (Exception e1) {
						System.err.println("Got an exception! ");
						System.err.println(e1.getMessage());

					}
				}
			}
		});
		message.setBounds(12, 42, 408, 152);
		contentPane.add(message);
		message.setColumns(10);
		
		JLabel lblYourMessage = new JLabel("Your message:");
		lblYourMessage.setBounds(12, 13, 156, 16);
		contentPane.add(lblYourMessage);
		
		JButton btnSendMessage = new JButton("Send message");
		btnSendMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					
					Connection myConn = DriverManager.getConnection(MyMethods.DB_URL, MyMethods.USER, MyMethods.PASS);
					Statement myStmt = myConn.createStatement();
					int result = myStmt.executeUpdate("INSERT INTO messages (username,message ) "
							+ "VALUES ('"+MyMethods.getGlobUsername()+"','"+ message.getText()+"')");		
					JOptionPane.showMessageDialog(null, "Your message has been sent");
					setVisible(false);
					myConn.close();
				} catch (Exception e1) {
					System.err.println("Got an exception! ");
					System.err.println(e1.getMessage());

				}
			}
			
		});
		btnSendMessage.setBounds(139, 207, 143, 25);
		contentPane.add(btnSendMessage);
	}
}
