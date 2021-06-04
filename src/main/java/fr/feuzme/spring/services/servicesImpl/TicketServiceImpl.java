package fr.feuzme.spring.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.feuzme.spring.models.Ticket;
import fr.feuzme.spring.repositories.TicketRrepository;
import fr.feuzme.spring.services.GenericService;

public class TicketServiceImpl implements GenericService<Ticket> {
	@Autowired
	private TicketRrepository repo;
	@Override
	public List<Ticket> findAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public Ticket findById(Integer id) {
		// TODO Auto-generated method stub
		return this.repo.findById(id).get();
	}

	@Override
	public Ticket save(Ticket entity) {
		// TODO Auto-generated method stub
		return this.repo.save(entity);
	}

	@Override
	public Ticket update(Ticket entity) {
		Ticket TicketBdd = this.findById(entity.getId());
		
		entity.setPrix(entity.getPrix() == null ? TicketBdd.getPrix() : entity.getPrix());
		entity.setVisiteur(entity.getVisiteur() == null ? TicketBdd.getVisiteur() : entity.getVisiteur());
		
		return this.save(entity);
	}

	@Override
	public void delete(Ticket entity) {
		this.repo.delete(entity);		
	}

}
