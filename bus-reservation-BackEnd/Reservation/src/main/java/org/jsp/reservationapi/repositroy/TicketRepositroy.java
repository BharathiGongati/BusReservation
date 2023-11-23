package org.jsp.reservationapi.repositroy;

import org.jsp.reservationapi.dto.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepositroy extends JpaRepository<Ticket, Integer> {

}
