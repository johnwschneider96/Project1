package com.team.controllers;

import javax.servlet.http.HttpServletRequest;

import com.team.helper.TicketLoader;

public class FilterController
{
	public static String Filter(HttpServletRequest request)
	{
		/*
		 * Make helper to load in all tickets from db, add
		 * a filter field in each element to be manipulated here
		 * for filtering of tickets on window load 
		 * 
		 * Alter managercontroller to only send tickets with such field.
		 */
		
		String username = request.getParameter("username");
		String type = request.getParameter("type");
		String status = request.getParameter("status");
		
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
		
		System.out.println("username: "+username);
		System.out.println("type: "+type);
		System.out.println("status: "+status);
		
		TicketLoader.filterTickets(username, type, status);
		
		return "/html/FinanceManager.html";
	}
}