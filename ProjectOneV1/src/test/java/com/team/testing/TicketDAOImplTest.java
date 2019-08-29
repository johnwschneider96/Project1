package com.team.testing;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import com.team.core.Ticket;
import com.team.dao.TicketDAOImpl;

public class TicketDAOImplTest
{
	TicketDAOImpl impl = new TicketDAOImpl();
	
	@Test
	public void testInsertAndGetTicket()
	{
		Ticket ticket = new Ticket("username", 1.23, "description", "type", 1);
		
		impl.insertTicket(ticket);
		
		Ticket ticketout = impl.getTicketById(1);
		
		boolean equals = ticket.getEmployee_username() .equals( ticketout.getEmployee_username() );
		
		assertEquals(equals, true);
	}
	
	@Test
	public void testGetTicketsByType()
	{
		Ticket t1 = new Ticket("username", 1.23, "description1", "travel", 1);
		Ticket t2 = new Ticket("username", 1.23, "description2", "travel", 1);
		Ticket t3 = new Ticket("username", 1.23, "description3", "travel", 1);
		Ticket t4 = new Ticket("username", 1.23, "description4", "food", 1);
		
		impl.insertTicket(t1);
		impl.insertTicket(t2);
		impl.insertTicket(t3);
		impl.insertTicket(t4);
		
		ArrayList<Ticket> tickets = impl.getTicketsByType("travel");
		
		for(Ticket s : tickets) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testGetAllTickets()
	{
		ArrayList<Ticket> tickets = impl.getAllTickets();
		
		for(Ticket s : tickets) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testUpdateTicket()
	{
		Ticket ticket = new Ticket(5,"username", 1.23, "0351934", "gjsen", 7);
		impl.updateTicket(ticket);
	}
	
	@Test
	public void testDeleteTicket()
	{
		Ticket ticket = new Ticket(2,"username", 1.23, "description4", "food", 1);
		impl.deleteTicket(ticket);
	}
}