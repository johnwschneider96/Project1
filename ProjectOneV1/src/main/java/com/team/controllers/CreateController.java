package com.team.controllers;

import javax.servlet.http.HttpServletRequest;

import com.team.core.Ticket;
import com.team.core.User;
import com.team.dao.TicketDAOImpl;
import com.team.helper.TicketLoader;

public class CreateController
{
	public static String Create(HttpServletRequest request)
	{
		User u = (User) request.getSession().getAttribute("User");

		String username = u.getUsername();
		String type = request.getParameter("type");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String description = request.getParameter("description");

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

		return "/html/Employee.html";
	}
}
