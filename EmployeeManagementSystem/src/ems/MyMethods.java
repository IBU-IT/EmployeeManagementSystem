package ems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.*;

public class MyMethods {
	public static final String USER = "root";
	public static final String PASS = "sifrasifra";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/nova_sema?autoReconnect=true&useSSL=false";
	// -------------------------------

	private static String globLastname;

	public static String getGlobLastname() {
		return globLastname;
	}

	public static void setGlobLastname(String globLastname) {
		MyMethods.globLastname = globLastname;
	}
	// -------------------------------

	private static String globTypeStr;

	public static String getGlobTypeStr() {
		return globTypeStr;
	}

	public static void setGlobTypeStr(String globTypeStr) {
		MyMethods.globTypeStr = globTypeStr;
	}
	// -------------------------------

	private static double globSalary;

	public static double getGlobSalary() {
		return globSalary;
	}

	public static void setGlobSalary(double globSalary) {
		MyMethods.globSalary = globSalary;
	}

	// -------------------------------
	private static String globFirstname;

	public static String getGlobFirstname() {
		return globFirstname;
	}

	public static void setGlobFirstname(String globFirstname) {
		MyMethods.globFirstname = globFirstname;
	}
	// -------------------------------

	private static String GlobPassword;

	public static String getGlobPassword() {
		return GlobPassword;
	}

	public static void setGlobPassword(String GlobPassword) {
		MyMethods.GlobPassword = GlobPassword;
	}

	// -------------------------------

	private static String globUsername;

	public static String getGlobUsername() {
		return globUsername;
	}

	public static void setGlobUsername(String globUsername) {
		MyMethods.globUsername = globUsername;
	}

	// -------------------------------

	private static String globType;

	public static String getGlobType() {
		return globType;
	}

	public static void setGlobType(String globType) {
		MyMethods.globType = globType;
	}

	// -------------------------------

	private static int globID;

	public static int getGlobID() {
		return globID;
	}

	public static void setGlobID(int userid) {
		MyMethods.globID = userid;
	}

	// -------------------------------

	private static int globHW = 0;

	public static int getGlobHW() {
		return globHW;
	}

	public static void setGlobHW(int globHW) {
		MyMethods.globHW = globHW;
	}

	// -------------------------------
	private static int globchangePass;

	public static int getGlobchangePass() {
		return globchangePass;
	}

	public static void setGlobchangePass(int globchangePass) {
		MyMethods.globchangePass = globchangePass;
	}

	// -------------------------------
		private static int globHoursWorked;

		public static int getGlobHoursWorked() {
			return globHoursWorked;
		}

		public static void setGlobHoursWorked(int globHoursWorked) {
			MyMethods.globHoursWorked = globHoursWorked;
		}
		

	// -------------------------------

	// -------------------------------
	public void changePass(String ChangePassUser, String ChangePass) {
		try {
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);

			Statement myStmt = myConn.createStatement();

			String sql = "update users" + " set password = '" + ChangePass + "' where username='" + ChangePassUser
					+ "';";
			myStmt.executeUpdate(sql);

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	// -------------------------------
	public void deleteMessage(){
		try {

			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);

			Statement myStmt = myConn.createStatement();
			
			String sql = "DELETE FROM messages WHERE msg_status = 'read'";
			myStmt.executeUpdate(sql);
			

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}
	
	// -------------------------------
	public void readMessage() {
		try {

			Connection myConn = DriverManager.getConnection(MyMethods.DB_URL, MyMethods.USER, MyMethods.PASS);

			Statement myStmt = myConn.createStatement();
			ResultSet result = myStmt.executeQuery("SELECT * FROM messages where msg_status = 'unread'");
			int msgID = 0;
			while (result.next()) {
				msgID = result.getInt("msg_id");
				JOptionPane.showMessageDialog(null,
						"You have a new message from user: " + result.getString("username"));
				JOptionPane.showMessageDialog(null, "Message: " + result.getString("message"));
				MyMethods mthds= new MyMethods();
				mthds.setRead(msgID);
				
				}
			if (result.next() == false) {
				JOptionPane.showMessageDialog(null, "No new messages",null, JOptionPane.WARNING_MESSAGE);
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	// -------------------------------
	public void setRead(int msgID) {
		try {

			Connection myConn = DriverManager.getConnection(MyMethods.DB_URL, MyMethods.USER, MyMethods.PASS);

			Statement myStmt = myConn.createStatement();
			String sql = "update messages" + " set msg_status = 'read' where msg_id='" + msgID
					+ "';";
			myStmt.executeUpdate(sql);
		

		} catch (Exception exc) {
			exc.printStackTrace();
		}

	}

	
	// -------------------------------

	public int login(String userText, String passText) {

		int userPermision = 0;
		try {

			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);

			Statement myStmt = myConn.createStatement();

			ResultSet result = myStmt.executeQuery(
					"SELECT hoursWorkedMonth, user_id,username,password,first_name,last_name, type_id, salary FROM Users WHERE username='"
							+ userText + "' AND password='" + passText + "'");
			if (result.next() == false) {
				JOptionPane.showMessageDialog(null, "Wrong information");
			}
			userPermision = result.getInt("type_id");
			String username = result.getString("username");
			String password = result.getString("password");
			int userid = result.getInt("user_id");
			int hw = result.getInt("hoursWorkedMonth");
			MyMethods.setGlobID(userid);
			MyMethods.setGlobHW(hw);
			MyMethods.setGlobFirstname(result.getString("first_name"));
			MyMethods.setGlobLastname(result.getString("last_name"));
			MyMethods.setGlobUsername(username);
			MyMethods.setGlobSalary(result.getDouble("salary"));
			MyMethods.setGlobHoursWorked(result.getInt("hoursWorkedMonth"));

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return userPermision;
	}

	public void setHoursDB(int hoursWorked) {
		try {
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);

			Statement myStmt = myConn.createStatement();

			String sql = "update users" + " set hoursWorkedMonth = " + hoursWorked + " where user_id="
					+ MyMethods.getGlobID() + ";";
			myStmt.executeUpdate(sql);
			MyMethods.setGlobHW(hoursWorked);

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public int checkEmployee(String usernameCheck) {
		int verify = 0;
		try {
			
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);

			Statement myStmt = myConn.createStatement();
			ResultSet result = myStmt.executeQuery(
					"SELECT hoursWorkedMonth, user_id,username,password,first_name,last_name, type_id FROM Users WHERE username = '"
							+ usernameCheck + "'");
			
			if (result.next() == false) {
				JOptionPane.showMessageDialog(null, "There is no employee with username: "+usernameCheck);
				verify = 1;
			}
			
			MyMethods.setGlobHoursWorked(result.getInt("hoursWorkedMonth"));
			MyMethods.setGlobID(result.getInt("user_id"));
			MyMethods.setGlobType(result.getString("type_id"));
			MyMethods.setGlobUsername(result.getString("username"));
			MyMethods.setGlobPassword(result.getString("password"));
			MyMethods.setGlobFirstname(result.getString("first_name"));
			MyMethods.setGlobLastname(result.getString("last_name"));
			MyMethods.setGlobSalary(result.getDouble("salary"));

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return verify;
	}

	public void deleteEmployee(String usernameDel) {
		try {
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);

			Statement myStmt = myConn.createStatement();

			String sql = "DELETE FROM Users WHERE username='" + usernameDel + "'";
			myStmt.executeUpdate(sql);

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	public void newUser(int salary, String Username, String Pass, String Firstname, String Lastname, int UserType) {
		try {

			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement myStmt = myConn.createStatement();
			int result = myStmt.executeUpdate(
					"INSERT INTO users (user_id, username, password, first_name, last_name, hoursWorkedMonth, type_id, salary) "
							+ "VALUES (default, '" + Username + "', '" + Pass + "', '" + Firstname + "', '" + Lastname
							+ "', '0', '" + UserType + "', '" + salary + "')");
			JOptionPane.showMessageDialog(null, "User " + Username + " has been added to the database.");
			myConn.close();
		} catch (Exception e1) {
			System.err.println("Got an exception! ");
			System.err.println(e1.getMessage());

		}
	}

	public double calculateSalary(String username) {
		double salary = 0;

		try {
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);

			Statement myStmt = myConn.createStatement();
			ResultSet result = myStmt
					.executeQuery("SELECT hoursWorkedMonth, salary FROM Users WHERE username = '" + username + "'");

			if (result.next() == false) {
				JOptionPane.showMessageDialog(null, "Wrong information");
			}
			int hours = result.getInt("hoursWorkedMonth");
			salary = result.getDouble("salary");
			salary = salary * hours;

		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return salary;
	}

	public void changeSalary(String username, double newSalary) {
		try {
			Connection myConn = DriverManager.getConnection(DB_URL, USER, PASS);

			Statement myStmt = myConn.createStatement();

			String sql = "update users" + " set salary = '" + newSalary + "' where username='" + username + "';";
			myStmt.executeUpdate(sql);

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}