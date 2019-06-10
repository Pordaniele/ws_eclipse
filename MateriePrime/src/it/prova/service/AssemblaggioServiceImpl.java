package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoMateria;
@Component
public class AssemblaggioServiceImpl implements AssemblaggioService{

	@Override
	public void inAssemblaggio(MateriaPrima materiaPrima) {
		
		materiaPrima.setStato(StatoMateria.IN_ASSEMBLAGGIO);
		System.out.println("Stato lavoro: "+materiaPrima.getStato());
		
		System.out.println("Fine assemblaggio...");
		
		
	}

}
