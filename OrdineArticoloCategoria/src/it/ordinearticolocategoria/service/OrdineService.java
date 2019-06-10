package it.ordinearticolocategoria.service;

import java.util.List;

import it.ordinearticolocategoria.dao.OrdineDAO;
import it.ordinearticolocategoria.model.Categoria;
import it.ordinearticolocategoria.model.Ordine;

public interface OrdineService {
	public List<Ordine> listAll() throws Exception;

	public Ordine caricaSingoloOrdine(Long id) throws Exception;

	public void aggiorna(Ordine ordineInstance) throws Exception;

	public void inserisciNuovo(Ordine ordineInstance) throws Exception;

	public void rimuovi(Ordine ordineInstance) throws Exception;

	public List<Ordine> findByExample(Ordine example) throws Exception;
	
	public void setOrdineDAO(OrdineDAO ordineDAO);

	public List<Ordine> ordineEffetturatiPerCategoria(Categoria categoria) throws Exception;
}
