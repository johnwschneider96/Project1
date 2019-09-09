package com.team.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.team.core.Ticket;
import com.team.helper.TicketLoader;
import com.team.logging.Logging;

public class ManagerController
{
	public static String Manage(HttpServletRequest request, HttpServletResponse response)
	{
		sendTickets(TicketLoader.getTickets(), response);
		
		Logging.log.info("Loading all tickets to be displayed to Finance Manager.");
		
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