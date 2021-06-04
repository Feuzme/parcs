package fr.feuzme.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.feuzme.spring.models.Parc;
import fr.feuzme.spring.services.GenericService;

@RestController
@RequestMapping("parcs")
@CrossOrigin
public class ParcController {
	@Autowired
	private GenericService<Parc> service;
	
	@GetMapping()
	public List<Parc> findAll(){
		return this.service.findAll();
	}
	
	@GetMapping("{id}")
	public Parc findById(@PathVariable Integer id) {
		return this.service.findById(id);
	}
	
	@PostMapping()
	public Parc save(@RequestBody Parc parc) {
		return this.service.save(parc);
	}
	
	@PutMapping()
	public Parc update(@RequestBody Parc parc) {
		return this.service.update(parc);
	}
	
	@DeleteMapping()
	public void delete(@RequestBody Parc parc) {
		this.service.delete(parc);
	}
}
