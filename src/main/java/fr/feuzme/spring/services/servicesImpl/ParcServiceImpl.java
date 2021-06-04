package fr.feuzme.spring.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.feuzme.spring.models.Parc;
import fr.feuzme.spring.repositories.ParcRepository;
import fr.feuzme.spring.services.GenericService;

public class ParcServiceImpl implements GenericService<Parc> {
	@Autowired
	private ParcRepository repo;
	@Override
	public List<Parc> findAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public Parc findById(Integer id) {
		// TODO Auto-generated method stub
		return this.repo.findById(id).get();
	}

	@Override
	public Parc save(Parc entity) {
		// TODO Auto-generated method stub
		return this.repo.save(entity);
	}

	@Override
	public Parc update(Parc entity) {
		Parc ParcBdd = this.findById(entity.getId());
		
		entity.setCapacite(entity.getCapacite() == null ? ParcBdd.getCapacite() : entity.getCapacite());
		entity.setNom(entity.getNom() == null ? ParcBdd.getNom() : entity.getNom());
		
		return this.save(entity);
	}

	@Override
	public void delete(Parc entity) {
		this.repo.delete(entity);		
	}

}
