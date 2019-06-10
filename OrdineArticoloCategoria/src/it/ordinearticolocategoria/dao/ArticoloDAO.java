package it.ordinearticolocategoria.dao;
import java.util.List;

import it.ordinearticolocategoria.model.Articolo;
import it.ordinearticolocategoria.model.Categoria;

public interface ArticoloDAO extends IBaseDAO<Articolo>{

	
	public List<Articolo> sommaTotalePrezzoArticoliLegatiAUnaCategoria(Categoria categoriaInput) throws Exception;
}
