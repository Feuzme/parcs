package fr.feuzme.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.feuzme.spring.models.Attraction;

public interface AttractionRepository extends JpaRepository<Attraction, Integer> {

}
