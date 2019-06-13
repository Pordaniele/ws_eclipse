package it.prova.ebayjpa.dao.annuncio;

import java.util.List;

import it.prova.ebayjpa.dao.IBaseDAO;
import it.prova.ebayjpa.model.Annuncio;

public interface AnnuncioDAO extends IBaseDAO<Annuncio>{
public List<Annuncio> findByExampleEager(Annuncio annuncioInput);
public Annuncio caricaEager(long id);
}
