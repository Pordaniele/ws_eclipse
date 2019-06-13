package it.prova.ebayjpa.dao.utente;

import it.prova.ebayjpa.dao.IBaseDAO;
import it.prova.ebayjpa.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente>{
public Utente executeLogin(String username,String password);
	
	public Utente CaricaEager(long id);
	
	public Utente executeFetchLogin(String username, String password);
	
	public Utente CaricaEagerAnnunci(long id);
}
