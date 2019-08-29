package com.team.controllers;

import javax.servlet.http.HttpServletRequest;

public class LogoutController
{
	public static String Logout(HttpServletRequest request)
	{
		request.getSession().invalidate();
		
		return "/html/Login.html";
	}
}