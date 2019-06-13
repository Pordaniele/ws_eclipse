package it.prova.ebayjpa.service.utente;

import java.util.List;

import it.prova.ebayjpa.model.Utente;

public interface UtenteService {

	public List<Utente> listAllUtenti();

	public Utente caricaSingoloUtente(Long id);

	public void aggiorna(Utente utenteInstance);

	public void inserisciNuovo(Utente utenteInstance);

	public void rimuovi(Utente utenteInstance);

	public List<Utente> findByExample(Utente example);

	public Utente eseguiAccesso(String username, String password);

	public Utente CaricaEager(long id);

	public Utente executeFetchLogin(String username, String password);
	
	public Utente CaricaEagerAnnunci(long id);
}
