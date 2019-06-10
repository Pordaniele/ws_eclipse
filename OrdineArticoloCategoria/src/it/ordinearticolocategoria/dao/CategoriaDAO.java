package it.ordinearticolocategoria.dao;

import java.util.List;


import it.ordinearticolocategoria.model.Categoria;
import it.ordinearticolocategoria.model.Ordine;

public interface CategoriaDAO extends IBaseDAO<Categoria>{

	
	public List<Categoria> TutteLeCategorieDiUnOrdine(Ordine ordineInput) throws Exception;	
}
