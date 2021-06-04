package fr.feuzme.spring.services.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.feuzme.spring.models.Visiteur;
import fr.feuzme.spring.repositories.VisiteurRepository;
import fr.feuzme.spring.services.GenericService;

public class VisiteurServiceImpl implements GenericService<Visiteur> {
	@Autowired
	private VisiteurRepository repo;
	@Override
	public List<Visiteur> findAll() {
		// TODO Auto-generated method stub
		return this.repo.findAll();
	}

	@Override
	public Visiteur findById(Integer id) {
		// TODO Auto-generated method stub
		return this.repo.findById(id).get();
	}

	@Override
	public Visiteur save(Visiteur entity) {
		// TODO Auto-generated method stub
		return this.repo.save(entity);
	}

	@Override
	public Visiteur update(Visiteur entity) {
		Visiteur VisiteurBdd = this.findById(entity.getId());
		
		entity.setAge(entity.getAge() == null ? VisiteurBdd.getAge() : entity.getAge());
		entity.setNom(entity.getNom() == null ? VisiteurBdd.getNom() : entity.getNom());
		entity.setPrenom(entity.getPrenom() == null ? VisiteurBdd.getNom() : entity.getPrenom());
		
		return this.save(entity);
	}

	@Override
	public void delete(Visiteur entity) {
		this.repo.delete(entity);		
	}

}
