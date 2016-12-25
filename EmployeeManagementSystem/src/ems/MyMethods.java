package ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.*;
public class MyMethods {
	
	public int login(String userText, String passText) {
		int loginVerification = 0;
		String pasvord = "dummy";
		try {
			
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nova_sema", "asmir", "sifra");
			
			Statement myStmt = myConn.createStatement();
			
			ResultSet result = myStmt.executeQuery("SELECT id, username, password FROM Users WHERE username='"+userText+"' AND password='"+passText+"'");
			if (result.next() == false) {
				JOptionPane.showMessageDialog(null, "Pogresni Podaci");
			}

			int id = result.getInt("id");
			String username = result.getString("username");
			String password = result.getString("password");
			
			//Provjera
			if (id == 1) {
				JOptionPane.showMessageDialog(null, "admin");
			}else{
				JOptionPane.showMessageDialog(null, "not admin");
			}
			
			
			
			
		}
		catch (Exception exc){
			exc.printStackTrace();
		}
		return loginVerification;
	}

}