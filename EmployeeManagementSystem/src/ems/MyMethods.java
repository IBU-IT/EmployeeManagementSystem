package ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.*;

public class MyMethods {

	

	public int login(String userText, String passText) {

		int userPermision = 0;
		String pasvord = "dummy";
		try {

			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nova_sema?autoReconnect=true&useSSL=false", "root", "pasvordzasql");

			Statement myStmt = myConn.createStatement();

			ResultSet result = myStmt
					.executeQuery("SELECT user_id, type_id, username, password FROM Users WHERE username='" + userText
							+ "' AND password='" + passText + "'");
			if (result.next() == false) {
				JOptionPane.showMessageDialog(null, "Pogresni Podaci");
			}
			userPermision = result.getInt("type_id");
			String username = result.getString("username");
			String password = result.getString("password");
			int userid = result.getInt("user_id");
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return userPermision;
	}

	

}