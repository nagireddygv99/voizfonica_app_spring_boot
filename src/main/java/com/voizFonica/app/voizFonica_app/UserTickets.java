package com.voizFonica.app.voizFonica_app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_tickets")
public class UserTickets {
	
	@Id
	@Column(name="ticket_number")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketNumber;
	
	@Column(name="description")
	private String description;
	
	@Column(name="ticket_status")
	private String ticketStatus;
	
	@Column(name="user_number")
	private String userNumber;
	
	public UserTickets() {
	}

	public UserTickets(int ticketNumber, String description, String ticketStatus, String userNumber) {
		super();
		this.ticketNumber = ticketNumber;
		this.description = description;
		this.ticketStatus = ticketStatus;
		this.userNumber = userNumber;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	
	
}
