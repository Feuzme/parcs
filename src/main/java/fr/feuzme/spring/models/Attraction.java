package fr.feuzme.spring.models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Attraction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "nb_places")
	private Integer nbPlaces;
	
	@ManyToOne
	@JoinColumn(name ="parc_id")
	private Parc parc;
	
	@ManyToMany
	@JoinTable(
			name="attraction_has_visiteur",
			joinColumns= @JoinColumn(name = "attraction_id"),
			inverseJoinColumns = @JoinColumn(name = "visiteur_id")
			)
	private Collection<Visiteur> visiteurs;
}
