package com.team.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.team.core.Ticket;

public class TicketDAOImpl implements TicketDAO
{
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
	
	public TicketDAOImpl() {
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void insertTicket(Ticket ticket) {
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Tickets (employee_username, amount, ticket_description,"
																			+ "type, status) VALUES (?,?,?,?,?)");
			
			ps.setString(1, ticket.getEmployee_username());
			ps.setDouble(2, ticket.getAmount());
			ps.setString(3, ticket.getDescription());
			ps.setString(4, ticket.getType());
			ps.setInt(5, ticket.getStatus());
			
			ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Ticket getTicketById(int id) {
		Ticket ticket = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Tickets WHERE ticketID = ?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
				ticket = new Ticket(id, rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return ticket;
	}

	@Override
	public ArrayList<Ticket> getTicketsByType(String type) {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		Ticket ticket = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Tickets WHERE type = ?");
			ps.setString(1, type);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ticket = new Ticket(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getInt(6));
				
				tickets.add(ticket);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}
	
	@Override
	public ArrayList<Ticket> getTicketsByUsername(String username) {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		Ticket ticket = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Tickets WHERE employee_username=?");
			
			ps.setString(1, username);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ticket = new Ticket(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getInt(6));
				
				tickets.add(ticket);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}

	@Override
	public ArrayList<Ticket> getAllTickets() {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		Ticket ticket = null;
		
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Tickets");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				ticket = new Ticket(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4), rs.getString(5), rs.getInt(6));
				
				tickets.add(ticket);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}

	@Override
	public void updateTicket(Ticket ticket) {
		try {
			CallableStatement cs = conn.prepareCall("{call update_ticket(?,?,?,?,?,?)}");
			
			cs.setInt(1, ticket.getTicket_ID());
			cs.setString(2, ticket.getEmployee_username());
			cs.setDouble(3, ticket.getAmount());
			cs.setString(4, ticket.getDescription());
			cs.setString(5, ticket.getType());
			cs.setInt(6, ticket.getStatus());
			
			cs.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateTicketById(int id, int status) {
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE Tickets SET Tickets.status=? WHERE Tickets.ticketId=?");
			
			ps.setInt(1, status);
			ps.setInt(2, id);
			
			ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteTicket(Ticket ticket) {
		try {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM Tickets WHERE ticketId = ?");
			
			ps.setInt(1,ticket.getTicket_ID());
			
			ps.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}