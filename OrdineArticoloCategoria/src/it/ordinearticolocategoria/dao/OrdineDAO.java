package it.ordinearticolocategoria.dao;

import java.util.List;
import java.util.Set;

import it.ordinearticolocategoria.model.Categoria;
import it.ordinearticolocategoria.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine> {

	public List<Ordine> ordineEffetturatiPerCategoria(Categoria categoria) throws Exception;
	
}
