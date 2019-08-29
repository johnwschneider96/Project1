package com.team.core;

public class Ticket
{
	private int ticket_ID;
	private String employee_username;
	private double amount;
	private String description;
	private String type;
	private int status;
	
	public Ticket(int ticket_ID, String employee_username, double amount, String description, String type, int status) {
		this.ticket_ID = ticket_ID;
		this.employee_username = employee_username;
		this.amount = amount;
		this.description = description;
		this.type = type;
		this.status = status;
	}
	
	public Ticket(String employee_username, double amount, String description, String type, int status) {
		this.ticket_ID = 0;
		this.employee_username = employee_username;
		this.amount = amount;
		this.description = description;
		this.type = type;
		this.status = status;
	}
	
	public Ticket() {
		
	}

	public int getTicket_ID() {
		return ticket_ID;
	}

	public void setTicket_ID(int ticket_ID) {
		this.ticket_ID = ticket_ID;
	}

	public String getEmployee_username() {
		return employee_username;
	}

	public void setEmployee_username(String employee_username) {
		this.employee_username = employee_username;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Ticket [ticket_ID=" + ticket_ID + ", employee_username=" + employee_username + ", amount=" + amount
				+ ", description=" + description + ", type=" + type + ", status=" + status + "]";
	}
}