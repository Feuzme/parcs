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

import fr.feuzme.spring.models.Visiteur;
import fr.feuzme.spring.services.GenericService;

@RestController
@RequestMapping("visiteurs")
public class VisiteurController {
	@Autowired
	private GenericService<Visiteur> service;
	
	@GetMapping()
	public List<Visiteur> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Visiteur findById(@PathVariable Integer id) {
		return this.service.findById(id);
	}
	
	@PostMapping()
	public Visiteur save(Visiteur visiteur) {
		return this.service.save(visiteur);
	}
	
	@PutMapping()
	public Visiteur update(@RequestBody Visiteur visiteur) {
		return this.service.update(visiteur);
	}
	
	@DeleteMapping()
	public void delete(@RequestBody Visiteur visiteur) {
		this.service.delete(visiteur);
	}
}

