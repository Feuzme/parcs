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
import fr.feuzme.spring.services.GenericService;

@RestController
@RequestMapping("attractions")
public class AttractionController {
	@Autowired
	private GenericService<Attraction> service;
	
	@GetMapping()
	public List<Attraction> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Attraction findById(@PathVariable Integer id) {
		return this.service.findById(id);
	}
	
	@PostMapping()
	public Attraction save(Attraction attraction) {
		return this.service.save(attraction);
	}
	
	@PutMapping()
	public Attraction update(@RequestBody Attraction attraction) {
		return this.service.update(attraction);
	}
	
	@DeleteMapping()
	public void delete(@RequestBody Attraction attraction) {
		this.service.delete(attraction);
	}
}
