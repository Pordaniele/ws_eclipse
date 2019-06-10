package it.ordinearticolocategoria.service;

import java.util.List;

import it.ordinearticolocategoria.dao.ArticoloDAO;
import it.ordinearticolocategoria.model.Articolo;
import it.ordinearticolocategoria.model.Categoria;

public interface ArticoloService {
	public List<Articolo> listAll() throws Exception;

	public Articolo caricaSingoloArticolo(Long id) throws Exception;

	public void aggiorna(Articolo articoloInstance) throws Exception;

	public void inserisciNuovo(Articolo articoloInstance) throws Exception;

	public void rimuovi(Articolo articoloInstance) throws Exception;

	public List<Articolo> findByExample(Articolo example) throws Exception;
	
	public void setArticoloDAO(ArticoloDAO articoloDAO);
	
	public List<Articolo> sommaTotalePrezzoArticoliLegatiAUnaCategoria(Categoria categoriaInput) throws Exception;

}
