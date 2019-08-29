package com.team.dao;

import java.util.ArrayList;

import com.team.core.Ticket;

public interface TicketDAO
{
	public void insertTicket(Ticket ticket);
	
	public Ticket getTicketById(int id);
	
	public ArrayList<Ticket> getTicketsByType(String type);
	
	public ArrayList<Ticket> getAllTickets();
	
	public ArrayList<Ticket> getTicketsByUsername(String username);
	
	public void updateTicket(Ticket ticket);
	
	public void updateTicketById(int Id, int status);
	
	public void deleteTicket(Ticket ticket);
}