package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.app.util.Dbutil;

public class UserDao {
	public static boolean adminLogin(String username, String password) {
		try {
			Connection connection = Dbutil.getConnection();
			String sql = "SELECT * FROM users where email = ? AND password_hash=? AND role='ADMIN'";
			PreparedStatement selectStatement = connection.prepareStatement(sql);
			selectStatement.setString(1, username);
			selectStatement.setString(2, password);

			ResultSet rs = selectStatement.executeQuery();

			if (rs.next() && rs.getString(3).equals(username) && rs.getString(4).equals(password)) { // uname,pass,role
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean studentLogin(String username, String password) {
		try {
			Connection connection = Dbutil.getConnection();
			String sql = "SELECT * FROM users where email = ? AND password_hash=? AND role='STUDENT'";
			PreparedStatement selectStatement = connection.prepareStatement(sql);
			selectStatement.setString(1, username);
			selectStatement.setString(2, password);

			ResultSet rs = selectStatement.executeQuery();

			if (rs.next() && rs.getString(3).equals(username) && rs.getString(4).equals(password)) { // uname,pass
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static void registerUser(String username,String email, String password) {
		try {
			Connection connection = Dbutil.getConnection();
			String sql = "INSERT INTO users(name,email,password_hash,role) values(?,?,?,?)";
			PreparedStatement selectStatement = connection.prepareStatement(sql);
			selectStatement.setString(1, username);
			selectStatement.setString(2, email);
			selectStatement.setString(3, password);
			selectStatement.setString(4,"STUDENT");

			selectStatement.executeUpdate();
			System.out.println("Registration Succsess!\n");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}




