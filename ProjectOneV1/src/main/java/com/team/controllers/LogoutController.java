package com.team.controllers;

import javax.servlet.http.HttpServletRequest;

import com.team.helper.TicketLoader;
import com.team.logging.Logging;

public class LogoutController
{
	public static String Logout(HttpServletRequest request)
	{
		request.getSession().invalidate();
		
		TicketLoader.update();
		
		Logging.log.info("Logging current user out.");
		
		return "/html/Login.html";
	}
}