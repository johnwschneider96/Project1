package com.team.controllers;

import javax.servlet.http.HttpServletRequest;

import com.team.dao.TicketDAOImpl;
import com.team.helper.TicketLoader;

public class TicketController
{
	public static String Act(HttpServletRequest request)
	{
		String parameter = request.getParameter("action");
		String info[] = parameter.split("-");
		
		TicketDAOImpl ticketDAOImpl = new TicketDAOImpl();
		
		switch(info[0]) {
		case "Approve":
			ticketDAOImpl.updateTicketById(Integer.parseInt(info[1]), 2);
			break;
		case "Deny":
			ticketDAOImpl.updateTicketById(Integer.parseInt(info[1]), 3);
			break;
		}
		
		TicketLoader.update();
		
		return "/html/FinanceManager.html";
	}
}