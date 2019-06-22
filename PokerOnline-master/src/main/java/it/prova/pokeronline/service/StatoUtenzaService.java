package it.prova.pokeronline.service;
import java.util.List;

import it.prova.pokeronline.model.StatoUtenza;

public interface StatoUtenzaService {

	public List<StatoUtenza> listAllStatiUtenza();
	
	public StatoUtenza caricaSingolo(Long id);
	
	public void aggiorna(StatoUtenza statoUtenzaInstance);
	
	public void inserisciNuovo(StatoUtenza statoUtenzaInstance);
	
	public void rimuovi(StatoUtenza statoUtenzaInstance);
	
	public List<StatoUtenza> findByExample(StatoUtenza example);

}
