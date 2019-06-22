package it.prova.ebayjpa.dao.categoria;

import it.prova.ebayjpa.dao.IBaseDAO;
import it.prova.ebayjpa.model.Categoria;
import it.prova.ebayjpa.model.Utente;

public interface CategoriaDAO extends IBaseDAO<Categoria>{

	
	public Categoria caricaEager(long id);
}
