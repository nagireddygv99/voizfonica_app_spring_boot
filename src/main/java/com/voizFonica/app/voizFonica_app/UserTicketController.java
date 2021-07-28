package com.voizFonica.app.voizFonica_app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserTicketController {
	@Autowired
	private UserTicketService userTicketService;
	
	
	@GetMapping("user-tickets/get-all-tickets")
	public List<UserTickets> getAllTickets() {
		return this.userTicketService.getAllTickets();
	}
	
	
	@GetMapping("user_tickets/get-user_tickets-by-ticket-id/{ticket_id}")
	public ResponseEntity<UserTickets> getTicketByPhoneNo(@PathVariable int ticket_id) {
		try {
			UserTickets userTickets = userTicketService.findTicketsByNumber(ticket_id);
			return new ResponseEntity<UserTickets>(userTickets,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("user_tickets/registertickets")
	public ResponseEntity<Integer> saveUser(@RequestBody UserTickets user) {
		try {
			user.setTicketStatus("o");
			userTicketService.saveUser(user);
			int tktNo = userTicketService.getTicketNumber(); 
			return new ResponseEntity<Integer>(tktNo,HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PutMapping("user-ticket/closeTicket")
	public ResponseEntity<?> closeTicketStatus(@RequestBody UserTickets userTicket) {
		try {
			UserTickets exstTkt = userTicketService.findTicketsByNumber(userTicket.getTicketNumber());
			exstTkt.setTicketStatus("c");
			userTicketService.saveUser(exstTkt);
//			userTicketService.closeTicket(userTicket.getTicketNumber());
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
		}
	}
	
}


