package it.prova.cartellaesattorialespringjpa.dao.utente;

import java.util.List;

import it.prova.cartellaesattorialespringjpa.dao.IBaseDAO;
import it.prova.cartellaesattorialespringjpa.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente> {

	public Utente executeLogin(String username,String password);
	
	public Utente CaricaEager(long id);
	
	public Utente executeFetchLogin(String username, String password);
}
