package it.prova.cartellaesattorialespringjpa.dao.utente;

import it.prova.cartellaesattorialespringjpa.dao.IBaseDAO;
import it.prova.cartellaesattorialespringjpa.model.Utente;

public interface UtenteDAO extends IBaseDAO<Utente> {

	public Utente executeLogin(String username,String password);
}
