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
import java.awt.Font;

public class LoginKlasa extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton deki = new JButton("LOGIN");
		deki.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
                if (textField.getText().equals("usernamezalogin")&&textField_1.getText().equals("sifrazalogin")){
                   
                        JOptionPane.showMessageDialog(null, "Logovan si");
                    }else{
                        JOptionPane.showMessageDialog(null, "Netacni podaci");
			}
		}
			
		}
                );
		deki.setBounds(167, 260, 97, 25);
		contentPane.add(deki);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(114, 202, 89, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(114, 231, 89, 16);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(203, 202, 131, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(203, 231, 131, 22);
		contentPane.add(textField_1);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null,"http://www.ibu.edu.ba/bs/" );
			}
		});
		label.setIcon(new ImageIcon(LoginKlasa.class.getResource("/images/burc.jpg")));
		label.setBounds(134, 13, 180, 156);
		contentPane.add(label);
		
		JLabel lblClickLogoFor = new JLabel("Click logo for more info");
		lblClickLogoFor.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblClickLogoFor.setBounds(167, 170, 133, 16);
		contentPane.add(lblClickLogoFor);
	}
}
