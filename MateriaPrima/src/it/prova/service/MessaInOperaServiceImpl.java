package it.prova.service;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoMateria;

@Component
public class MessaInOperaServiceImpl implements MessaInOperaService{

	@Override
	public void messaInOpera(MateriaPrima materiaPrima) {
		materiaPrima.setStato(StatoMateria.IN_MESSA_IN_OPERA);
		System.out.println("stato lavoro: "+materiaPrima.getStato());
		System.out.println("Fine messa in opera");
		
		materiaPrima.setStato(StatoMateria.PRONTA);
		System.out.println(materiaPrima.getStato()+"!!!!");
	}

}
