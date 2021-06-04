package fr.feuzme.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.feuzme.spring.models.Ticket;

public interface TicketRrepository extends JpaRepository<Ticket, Integer>{
	
}
