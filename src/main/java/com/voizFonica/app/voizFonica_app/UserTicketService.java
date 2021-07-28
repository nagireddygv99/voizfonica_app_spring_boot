package com.voizFonica.app.voizFonica_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTicketService {

	@Autowired
	private UserTicketRepository userRepo;
	
	public UserTickets findTicketsByNumber(int ticketId) {
		return userRepo.findById(ticketId).get();
	}
	
	public void saveUser(UserTickets user) {
		userRepo.save(user);
	}
	
	public List<UserTickets> getAllTickets() {
		return userRepo.findAll();
	}
	
	public Integer getTicketNumber() {
		return userRepo.getTiketNumber();
	}

	public void closeTicket(int ticketNumber) {
		userRepo.closeTicketStatus(ticketNumber);
	}
}
