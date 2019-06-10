package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoMateria;
@Component
public class LavorazioneServiceImpl implements LavorazioneService{

	@Override
	public void inLavorazione(MateriaPrima materiaPrima) {
		materiaPrima.setStato(StatoMateria.IN_LAVORAZIONE);
		System.out.println("stato lavoro: "+materiaPrima.getStato());
		
		
		System.out.println("Fine lavorazione...");
		}
		 
	

}
