package com.voizFonica.app.voizFonica_app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserTicketRepository extends JpaRepository<UserTickets, Integer>{
	@Query("select max(ut.ticketNumber) from UserTickets ut")
	Integer getTiketNumber();
	
	@Query("update UserTickets ut set ut.ticketStatus='c' where ut.ticketNumber=?1")
	void closeTicketStatus(int ticketNumber);
}
