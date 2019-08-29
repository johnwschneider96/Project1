package com.team.dao;

import java.util.ArrayList;

import com.team.core.User;

public interface UserDAO
{
	public User getUserByUsername(String userName);
	public ArrayList<User> getUserByRole(String Role);
	public ArrayList<User> getAllUser();
}