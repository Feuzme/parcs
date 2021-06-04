package fr.feuzme.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.feuzme.spring.models.Visiteur;

public interface VisiteurRepository extends JpaRepository<Visiteur, Integer> {

}
