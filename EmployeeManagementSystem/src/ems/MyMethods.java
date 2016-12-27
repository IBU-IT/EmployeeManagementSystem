package ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;



import java.sql.*;

public class MyMethods {
	static final String USER = "root";
	static final String PASS = "pasvordzasql";
	static final String DB_URL = "jdbc:mysql://localhost:3306/nova_sema?autoReconnect=true&useSSL=false";
	//-------------------------------
	
private static String globLastname;
	
	public static String getGlobLastname() {
		return globLastname;
	}

	public static void setGlobLastname(String globLastname) {
		MyMethods.globLastname = globLastname;
	}
	
	//-------------------------------
private static String globFirstname;
	
	public static String getGlobFirstname() {
		return globFirstname;
	}
	public static void setGlobFirstname(String globFirstname) {
		MyMethods.globFirstname = globFirstname;
	}
	//-------------------------------
	
private static String GlobPassword;
	
	public static String getGlobPassword() {
		return GlobPassword;
	}

	public static void setGlobPassword(String GlobPassword) {
		MyMethods.GlobPassword = GlobPassword;
	}
	
	
	
	//-------------------------------
	
	private static String globUsername;
	
	public static String getGlobUsername() {
		return globUsername;
	}

	public static void setGlobUsername(String globUsername) {
		MyMethods.globUsername = globUsername;
	}
	
	
	//-------------------------------
	
	private static String globType;
	public static String getGlobType() {
		return globType;
	}

	public static void setGlobType(String globType) {
		MyMethods.globType = globType;
	}
	
	//-------------------------------
	
	private static int globID;
	
	public static int getGlobID() {
		return globID;
	}

	public static void setGlobID(int userid) {
		MyMethods.globID = userid;
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
private static int globchangePass;
	
	
	public static int getGlobchangePass() {
		return globchangePass;
	}
	public static void setGlobchangePass(int globchangePass) {
		MyMethods.globchangePass = globchangePass;
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
	public void changePass(String ChangePassUser, String ChangePass) {
		try {
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);
	
			Statement myStmt = myConn.createStatement();
	
			String sql	= "update users"
						+ " set password = '"+ChangePass
						+ "' where username='"+ChangePassUser+"';";
			myStmt.executeUpdate(sql);
			
		
		} catch (Exception exc) {
		exc.printStackTrace();
		}
	}
		
	
	
	//-------------------------------
	
	public int login(String userText, String passText) {

		int userPermision = 0;
		try {
			
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);

			Statement myStmt = myConn.createStatement();

			ResultSet result = myStmt
					.executeQuery("SELECT hoursWorkedMonth, user_id,username,password,first_name,last_name, type_id FROM Users WHERE username='" + userText
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
					.executeQuery("SELECT hoursWorkedMonth, user_id,username,password,first_name,last_name, type_id FROM Users WHERE username = '" +usernameCheck+ "'");
			//int testtest = result.getInt("hoursWorkedMonth");
			if (result.next() == false) {
				JOptionPane.showMessageDialog(null, "Pogresni Podaci");
			}
			MyMethods.setGlobHoursWorked(result.getInt("hoursWorkedMonth"));
			MyMethods.setGlobID(result.getInt("user_id"));
			MyMethods.setGlobType(result.getString("type_id"));
			MyMethods.setGlobUsername(result.getString("username"));
			MyMethods.setGlobPassword(result.getString("password"));
			MyMethods.setGlobFirstname(result.getString("first_name"));
			MyMethods.setGlobLastname(result.getString("last_name"));
			
		} 
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	public void deleteEmployee(String usernameDel) {
		try {
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);
	
			Statement myStmt = myConn.createStatement();
	
			String sql	= "DELETE FROM Users WHERE username='"+usernameDel+"'";
			myStmt.executeUpdate(sql);
		
		
		} catch (Exception exc) {
		exc.printStackTrace();
		}
	}
}