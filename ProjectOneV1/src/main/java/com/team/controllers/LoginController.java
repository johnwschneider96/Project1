package com.team.controllers;

import javax.servlet.http.HttpServletRequest;

import com.team.core.User;
import com.team.dao.UserDAOImpl;

public class LoginController
{
	public static String Login(HttpServletRequest request)
	{
		String returnUri = "/html/Login.html";

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDAOImpl userDaoImpl = new UserDAOImpl();
		User user = userDaoImpl.getUserByUsername(username);

		request.getSession().setAttribute("User", user);

		if (username.equals(user.getUsername()) && password.equals(user.getPassword()))
		{
			if (user.getRole().equals("manager")) {
				returnUri = "/html/FinanceManager.html";
			} else if (user.getRole().equals("employee")) {
				returnUri = "/html/Employee.html";
			}
		}
		System.out.println(username);
		System.out.println(password);
		return returnUri;
	}
}