package com.team.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team.core.Employee;
import com.team.core.Manager;
import com.team.core.User;

public class UserDAOImpl implements UserDAO {
	private static String url = "jdbc:oracle:thin:@database1.cqmnrwj9hkjl.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "Admin";
	private static String password = "Admin123";

	private static Connection conn;

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public UserDAOImpl() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserByUsername(String empUsername) {
		User user = null;

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM EmployeeUsers WHERE USERNAME = ?");
			ps.setString(1, empUsername);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				if ((rs.getString(3)).equals("employee"))
					user = new Employee(rs.getString(1), rs.getString(2));
				else
					user = new Manager(rs.getString(1), rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	@Override
	public ArrayList<User> getUserByRole(String role) {
		ArrayList<User> usersByRole = new ArrayList<User>();
		User user = null;

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM EmployeeUsers WHERE ROLE = ?");
			ps.setString(1, role);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				if ((rs.getString(3)).equals("employee"))
					user = new Employee(rs.getString(1), rs.getString(2));
				else
					user = new Manager(rs.getString(1), rs.getString(2));
				
				usersByRole.add(user);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersByRole;
	}

	@Override
	public ArrayList<User> getAllUser() {
		ArrayList<User> allUsers = new ArrayList<User>();
		User user = null;

		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM EmployeeUsers");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				if ((rs.getString(3)).equals("employee"))
					user = new Employee(rs.getString(1), rs.getString(2));
				else
					user = new Manager(rs.getString(1), rs.getString(2));
				
				allUsers.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allUsers;
	}
}