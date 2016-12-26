package ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;



import java.sql.*;

public class MyMethods {
	static final String USER = "asmir";
	static final String PASS = "sifra";
	static final String DB_URL = "jdbc:mysql://localhost:3306/nova_sema?autoReconnect=true&useSSL=false";
	//-------------------------------
	
private static int GlobPassword;
	
	public static int getGlobPassword() {
		return GlobPassword;
	}

	public static void setGlobPassword(int GlobPassword) {
		MyMethods.GlobPassword = GlobPassword;
	}
	
	
	
	//-------------------------------
	
	private static int globUsername;
	
	public static int getGlobUsername() {
		return globUsername;
	}

	public static void setGlobUsername(int globUsername) {
		MyMethods.globUsername = globUsername;
	}
	
	
	//-------------------------------
	
	private static int globType;
	public static int getGlobType() {
		return globType;
	}

	public static void setGlobType(int globType) {
		MyMethods.globType = globType;
	}
	
	//-------------------------------
	
	private static int globID;
	
	public static int getGlobID() {
		return globID;
	}

	public static void setGlobID(int globID) {
		MyMethods.globID = globID;
	}
	
	//-------------------------------
	
	private static int globHW=0;
	
	public static int getGlobHW() {
		return globHW;
	}
	public static void setGlobHW(int globHW) {
		MyMethods.globHW = globHW;
	}
	
	//-------------------------------
	private static int globHoursWorked;
	
	public static int getGlobHoursWorked() {
		return globHoursWorked;
	}
	public static void setGlobHoursWorked(int globHoursWorked) {
		MyMethods.globHoursWorked = globHoursWorked;
	}
	
	//-------------------------------
	
	
	public int login(String userText, String passText) {

		int userPermision = 0;
		try {
			
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);

			Statement myStmt = myConn.createStatement();

			ResultSet result = myStmt
					.executeQuery("SELECT hoursWorkedMonth, user_id, type_id, username, password FROM Users WHERE username='" + userText
							+ "' AND password='" + passText + "'");
			if (result.next() == false) {
				JOptionPane.showMessageDialog(null, "Pogresni Podaci");
			}
			userPermision = result.getInt("type_id");
			String username = result.getString("username");
			String password = result.getString("password");
			int userid = result.getInt("user_id");
			int hw = result.getInt("hoursWorkedMonth");
			MyMethods.setGlobID(userid);
			MyMethods.setGlobHW(hw);
			
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return userPermision;
	}
	
	public void setHoursDB(int hoursWorked){
		try {
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);
	
			Statement myStmt = myConn.createStatement();
	
			String sql	= "update users"
						+ " set hoursWorkedMonth = "+hoursWorked
						+ " where user_id="+MyMethods.getGlobID()+";";
			myStmt.executeUpdate(sql);
			MyMethods.setGlobHW(hoursWorked);
		
		} catch (Exception exc) {
		exc.printStackTrace();
		}
	}
	public void checkEmployee(String usernameCheck){
		try {
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);
		
			Statement myStmt = myConn.createStatement();
			ResultSet result = myStmt
					.executeQuery("SELECT hoursWorkedMonth, user_id, type_id FROM Users WHERE username = '" +usernameCheck+ "'");
			//int testtest = result.getInt("hoursWorkedMonth");
			if (result.next() == false) {
				JOptionPane.showMessageDialog(null, "Pogresni Podaci");
			}
			MyMethods.setGlobHoursWorked(result.getInt("hoursWorkedMonth"));
			MyMethods.setGlobID(result.getInt("user_id"));
			MyMethods.setGlobType(result.getInt("type_id"));
			
			
		} 
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}