package fr.feuzme.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.feuzme.spring.models.Attraction;
import fr.feuzme.spring.models.Ticket;
import fr.feuzme.spring.services.GenericService;

@RestController
@RequestMapping("tickets")
public class TicketController {
	@Autowired
	private GenericService<Ticket> service;
	
	@GetMapping()
	public List<Ticket> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Ticket findById(@PathVariable Integer id) {
		return this.service.findById(id);
	}
	
	@PostMapping()
	public Ticket save(Ticket ticket) {
		return this.service.save(ticket);
	}
	
	@PutMapping()
	public Ticket update(@RequestBody Ticket ticket) {
		return this.service.update(ticket);
	}
	
	@DeleteMapping()
	public void delete(@RequestBody Ticket ticket) {
		this.service.delete(ticket);
	}
}