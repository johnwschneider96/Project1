package com.team.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper
{
	public static String process(HttpServletRequest request, HttpServletResponse response)
	{	
		switch(request.getRequestURI())
		{
		case "/ProjectOneV1/html/Manager.go":
			return ManagerController.Manage(request, response);
		
		case "/ProjectOneV1/html/Ticket.go":
			return TicketController.Act(request);
			
		case "/ProjectOneV1/html/Filter.go":
			return FilterController.Filter(request);
			
		case "/ProjectOneV1/html/Login.go":
			return LoginController.Login(request);
			
		case "/ProjectOneV1/html/Create.go":
			return CreateController.Create(request);
			
		case "/ProjectOneV1/html/PastTickets.go":
			return PastTicketsController.GetTickets(request, response);
			
		case "/ProjectOneV1/html/Logout.go":
			return LogoutController.Logout(request);
			
		default:
			return "/html/Login.html";
		}
	}
}