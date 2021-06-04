package fr.feuzme.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.feuzme.spring.models.Attraction;
import fr.feuzme.spring.models.Parc;
import fr.feuzme.spring.models.Ticket;
import fr.feuzme.spring.models.Visiteur;
import fr.feuzme.spring.services.GenericService;
import fr.feuzme.spring.services.servicesImpl.AttractionServiceImpl;
import fr.feuzme.spring.services.servicesImpl.ParcServiceImpl;
import fr.feuzme.spring.services.servicesImpl.TicketServiceImpl;
import fr.feuzme.spring.services.servicesImpl.VisiteurServiceImpl;

@Configuration
public class ServiceConfig {
	@Bean
	public GenericService<Attraction> attractionServiceFactory(){
		return new AttractionServiceImpl();
	}
	@Bean
	public GenericService<Parc> parcServiceFactory(){
		return new ParcServiceImpl();
	}
	@Bean
	public GenericService<Ticket> ticketServiceFactory(){
		return new TicketServiceImpl();
	}
	@Bean
	public GenericService<Visiteur> visiteurServiceFactory(){
		return new VisiteurServiceImpl();
	}
}
