package it.ordinearticolocategoria.service;

import it.ordinearticolocategoria.dao.ArticoloDAOImpl;
import it.ordinearticolocategoria.dao.CategoriaDAOImpl;
import it.ordinearticolocategoria.dao.OrdineDAOImpl;

public class MyServiceFactory {

	public static CategoriaService getCategoriaServiceInstance() {
		CategoriaService categoriaService = new CategoriaServiceImpl();
		categoriaService.setCategoriaDAO(new CategoriaDAOImpl());
		return categoriaService;
	}

	public static OrdineService getOrdineServiceInstance() {
		OrdineService ordineService = new OrdineServiceImpl();
		ordineService.setOrdineDAO(new OrdineDAOImpl());
		return ordineService;
	}
	
	public static ArticoloService getArticoloServiceInstance() {
		ArticoloService articoloService = new ArticoloServiceImpl();
		articoloService.setArticoloDAO(new ArticoloDAOImpl());
		return articoloService;
	}

}
