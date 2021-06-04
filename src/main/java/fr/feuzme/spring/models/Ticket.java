package fr.feuzme.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


import lombok.Data;

@Data
@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "prix")
	private Integer prix; 
	
	@OneToOne
	@JoinColumn(name = "visiteur_id", referencedColumnName = "id")
	private Visiteur visiteur;
}
