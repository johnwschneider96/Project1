package com.team.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.core.Ticket;
import com.team.core.User;
import com.team.dao.TicketDAOImpl;
import com.team.logging.Logging;

public class PastTicketsController
{
	public static String GetTickets(HttpServletRequest request, HttpServletResponse response)
	{
		User user = (User) request.getSession().getAttribute("User");
		
		TicketDAOImpl ticketDAOImpl = new TicketDAOImpl();
		
		sendTickets(ticketDAOImpl.getTicketsByUsername(user.getUsername()), response);
		
		Logging.log.info("Loading all tickets belonging to Employee: "+user.getUsername());
		
		return null;
	}
	
	private static void sendTickets(ArrayList<Ticket> tickets, HttpServletResponse response)
	{
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(tickets));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}