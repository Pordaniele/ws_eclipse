package it.prova.ebayjpa.service.annuncio;

import java.util.List;

import it.prova.ebayjpa.model.Annuncio;
import it.prova.ebayjpa.model.Categoria;

public interface AnnuncioService {
public List<Annuncio> list();
	
	public Annuncio get(long id);
	
	public void update(Annuncio o);
	
	public void insert(Annuncio o);
	
	public void delete(Annuncio o);
	
	public List<Annuncio> findByExample(Annuncio annuncioInstance);
	
	public List<Annuncio> findByExampleEager(Annuncio annuncioInput);
	
	public Annuncio caricaEager(long id);
	
	public List<Annuncio> cercaAnnuncioPerCategoria(Categoria categoria);
}
