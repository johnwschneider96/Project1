package com.team.controllers;

import javax.servlet.http.HttpServletRequest;

import com.team.core.User;
import com.team.dao.UserDAOImpl;
import com.team.logging.Logging;

public class LoginController
{
	public static String Login(HttpServletRequest request)
	{
		String returnUri = "/html/Login.html";

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDAOImpl userDaoImpl = new UserDAOImpl();
		User user = userDaoImpl.getUserByUsername(username);
		
		Logging.log.info("Attempting to login Username: "+username+", Password: "+password);
		
		if (user != null) {
			request.getSession().setAttribute("User", user);

			if (username.equals(user.getUsername()) && password.equals(user.getPassword())) {
				if (user.getRole().equals("manager")) {
					returnUri = "/html/FinanceManager.html";
					Logging.log.info("Login successful. Logging in Finance Manager: "+username);
				} else if (user.getRole().equals("employee")) {
					Logging.log.info("Login successful. Logging in Employee: "+username);
					returnUri = "/html/Employee.html";
				}
			}
		} else {
			Logging.log.warn("Login failed. User does not exist.");
		}
		
		return returnUri;
	}
}