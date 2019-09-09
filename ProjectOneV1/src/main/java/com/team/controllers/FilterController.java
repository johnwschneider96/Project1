package com.team.controllers;

import javax.servlet.http.HttpServletRequest;

import com.team.helper.TicketLoader;
import com.team.logging.Logging;

public class FilterController
{
	public static String Filter(HttpServletRequest request)
	{
		String username = request.getParameter("username");
		String type = request.getParameter("type");
		String status = request.getParameter("status");
		
		Logging.log.info("Filter by - Username: "+username+", Type: "+type+", Status: "+status+" requested.");
		
		switch(status) {
		case "Approved":
			status = "2";
			break;
		case "Denied":
			status = "3";
			break;
		case "Active":
			status = "1";
			break;
		}
		
		TicketLoader.filterTickets(username, type, status);
		
		return "/html/FinanceManager.html";
	}
}