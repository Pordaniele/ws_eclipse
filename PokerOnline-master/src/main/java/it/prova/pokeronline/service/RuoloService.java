package it.prova.pokeronline.service;
import java.util.List;

import it.prova.pokeronline.model.Ruolo;

public interface RuoloService {

	public List<Ruolo> listAllRuoli();
	
	public Ruolo caricaSingolo(Long id);
	
	public void aggiorna(Ruolo ruoloInstance);
	
	public void inserisciNuovo(Ruolo ruoloInstance);
	
	public void rimuovi(Ruolo ruoloInstance);
	
	public List<Ruolo> findByExample(Ruolo example);

}
