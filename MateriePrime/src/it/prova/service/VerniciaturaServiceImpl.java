package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoMateria;
@Component
public class VerniciaturaServiceImpl implements VerniciaturaService{

	@Override
	public void inVerniciatura(MateriaPrima materiaPrima) {
		materiaPrima.setStato(StatoMateria.IN_VERNICIATURA);
		System.out.println("stato lavoro: "+materiaPrima.getStato());
		System.out.println("Verniciatura completata...");
		
	}

}
