package it.prova.service;

import java.util.List;

import it.prova.model.Utente;

public interface UtenteService {
	public List<Utente> list();

	public Utente get(long id);

	public void update(Utente o);

	public void insert(Utente o);

	public void delete(Utente o);

	public List<Utente> findByExample(Utente utenteInstance);
}
