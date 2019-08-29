package com.team.helper;

import java.util.ArrayList;

import com.team.core.Ticket;
import com.team.dao.TicketDAOImpl;

public class TicketLoader
{
	public static ArrayList<Ticket> allTickets = new TicketDAOImpl().getAllTickets();
	public static ArrayList<Ticket> tickets = allTickets;
	
	public static ArrayList<Ticket> getTickets() {
		return tickets;
	}
	
	public static void update()
	{
		allTickets = new TicketDAOImpl().getAllTickets();
		tickets = allTickets;
	}
	
	public static void filterTickets(String username, String type, String status) {
		ArrayList<Ticket> filtered = new ArrayList<Ticket>();
		
		for(Ticket t : allTickets) {
			if(t.getEmployee_username().equals(username) || username.equals("")) {
				if(t.getType().equals(type) || type.equals("")) {
					if((t.getStatus()+"").equals(status) || status.equals("")) {
						filtered.add(t);
					}
				}
			}
		}
		
		tickets = filtered;
	}
}