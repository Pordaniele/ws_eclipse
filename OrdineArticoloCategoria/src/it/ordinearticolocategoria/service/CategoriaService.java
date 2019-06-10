package it.ordinearticolocategoria.service;

import java.util.List;

import it.ordinearticolocategoria.dao.CategoriaDAO;
import it.ordinearticolocategoria.model.Categoria;
import it.ordinearticolocategoria.model.Ordine;

public interface CategoriaService {
	public List<Categoria> listAll() throws Exception;

	public Categoria caricaSingolaCategoria(Long id) throws Exception;

	public void aggiorna(Categoria categoriaInstance) throws Exception;

	public void inserisciNuovo(Categoria categoriaInstance) throws Exception;

	public void rimuovi(Categoria categoriaInstance) throws Exception;

	public List<Categoria> findByExample(Categoria example) throws Exception;
	
	public void setCategoriaDAO(CategoriaDAO categoriaDAO);
	
	public List<Categoria> TutteLeCategorieDiUnOrdine(Ordine ordineInput) throws Exception;
}
