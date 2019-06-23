package it.prova.pokeronline.service;
import java.util.List;

import it.prova.pokeronline.model.Utente;

public interface UtenteService {

	public List<Utente> listAllUtenti();
	
	public Utente caricaSingolo(Long id);
	
	public void aggiorna(Utente utenteInstance);
	
	public void inserisciNuovo(Utente utenteInstance);
	
	public void rimuovi(Utente utenteInstance);
	
	public List<Utente> findByExample(Utente example);

	public Utente findByUsernameAndPassword(String username, String password);

	public Utente caricaUtentePerUsernamePasswordeRuolo(Long id);
	
	Utente findByUsername (String username);
}
