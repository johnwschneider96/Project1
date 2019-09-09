package com.team.controllers;

import javax.servlet.http.HttpServletRequest;

import com.team.core.Ticket;
import com.team.core.User;
import com.team.dao.TicketDAOImpl;
import com.team.helper.TicketLoader;
import com.team.logging.Logging;

public class CreateController
{
	public static String Create(HttpServletRequest request)
	{
		User u = (User) request.getSession().getAttribute("User");

		String username = u.getUsername();
		String type = request.getParameter("type");
		String amountString = request.getParameter("amount");
		String description = request.getParameter("description");
		
		Logging.log.info("Employee: "+u.getUsername()+" submitted ticket: "+type+", "+amountString+", "+description);
		
		if (isDouble(amountString)) {
			double amount = Double.parseDouble(amountString);
			
			TicketDAOImpl ticketDao = new TicketDAOImpl();

			Ticket ticket = new Ticket();

			ticket.setAmount(amount);
			ticket.setDescription(description);
			ticket.setEmployee_username(username);
			ticket.setStatus(1);
			ticket.setTicket_ID(1);
			ticket.setType(type);

			ticketDao.insertTicket(ticket);

			TicketLoader.update();
			
			Logging.log.info("Ticket saved.");
		} else {
			Logging.log.warn("Invalid amount entry. Ticket not saved.");
		}

		return "/html/Employee.html";
	}
	
	private static boolean isDouble(String str)
	{
		try{
			Double.parseDouble(str);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
}
