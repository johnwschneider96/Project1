package com.team.dao;

import java.util.ArrayList;

import com.team.core.Employee;
import com.team.core.User;

public class Test
{
	public static void main(String[] args)
	{
		/*TicketDAOImpl impl = new TicketDAOImpl();
		
		Ticket ticket = new Ticket(0, "employee", 200.00, "descript1", "FLIGHT", 1);
		Ticket ticket2 = new Ticket(0, "employee", 250.00, "descript2", "FOOD", 1);
		Ticket ticket3 = new Ticket(0, "employee", 400.00, "descript3", "LODGING", 1);
		Ticket ticket4 = new Ticket(0, "employee", 450.00, "descript4", "TRAVEL", 1);
		
		impl.insertTicket(ticket);
		impl.insertTicket(ticket2);
		impl.insertTicket(ticket3);
		impl.insertTicket(ticket4);*/
		
		UserDAOImpl imp = new UserDAOImpl();
		
		ArrayList<User> users = imp.getAllUser();
		
		for(User u : users) {
			System.out.println(u);
		}
		
		User u = new Employee("username","password");
		
		User found = imp.getUserByUsername("username");
		
		System.out.println(found);
	}
}