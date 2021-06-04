package fr.feuzme.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.feuzme.spring.models.Parc;

public interface ParcRepository extends JpaRepository<Parc, Integer>{

}
