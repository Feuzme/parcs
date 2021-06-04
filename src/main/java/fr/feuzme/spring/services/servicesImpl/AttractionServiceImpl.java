package fr.feuzme.spring.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.feuzme.spring.models.Attraction;
import fr.feuzme.spring.repositories.AttractionRepository;
import fr.feuzme.spring.services.GenericService;

public class AttractionServiceImpl implements GenericService<Attraction> {

	@Autowired
	private AttractionRepository repo;
	@Override
	public List<Attraction> findAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public Attraction findById(Integer id) {
		// TODO Auto-generated method stub
		return this.repo.findById(id).get();
	}

	@Override
	public Attraction save(Attraction entity) {
		// TODO Auto-generated method stub
		return this.repo.save(entity);
	}

	@Override
	public Attraction update(Attraction entity) {
		Attraction AttractionBdd = this.findById(entity.getId());
		
		entity.setNbPlaces(entity.getNbPlaces() == null ? AttractionBdd.getNbPlaces() : entity.getNbPlaces());
		entity.setNom(entity.getNom() == null ? AttractionBdd.getNom() : entity.getNom());
		entity.setParc(entity.getParc() == null ? AttractionBdd.getParc() : entity.getParc());
		entity.setVisiteurs(entity.getVisiteurs() == null ? AttractionBdd.getVisiteurs() : entity.getVisiteurs());
		
		return this.save(entity);
	}

	@Override
	public void delete(Attraction entity) {
		this.repo.delete(entity);		
	}

}
