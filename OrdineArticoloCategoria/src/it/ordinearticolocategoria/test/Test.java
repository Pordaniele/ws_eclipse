package it.ordinearticolocategoria.test;

import it.ordinearticolocategoria.model.Articolo;
import it.ordinearticolocategoria.model.Categoria;
import it.ordinearticolocategoria.model.Ordine;
import it.ordinearticolocategoria.service.ArticoloService;
import it.ordinearticolocategoria.service.CategoriaService;
import it.ordinearticolocategoria.service.MyServiceFactory;
import it.ordinearticolocategoria.service.OrdineService;

public class Test {

	public static void main(String[] args) {
		CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();
		ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();

		// TODO Auto-generated method stub
		try {
			// System.out.println(ordineServiceInstance.ordineEffetturatiPerCategoria(categoriaServiceInstance.caricaSingolaCategoria(1L)));
//			Categoria c1 = categoriaServiceInstance.caricaSingolaCategoria(1L);
//			Articolo a1=articoloServiceInstance.caricaSingoloArticolo(5L);
//			c1.aggiungiArticolo(a1);
//			categoriaServiceInstance.aggiorna(c1);
//			articoloServiceInstance.rimuovi(articoloServiceInstance.caricaSingoloArticolo(4L));
//			Ordine o1= new Ordine ("Franceschinos","Via del faro33");
//			ordineServiceInstance.inserisciNuovo(o1);
//			Articolo articolo1=new Articolo("Mollette", 15,o1);
//			Categoria cat1=categoriaServiceInstance.caricaSingolaCategoria(1L);
//			cat1.aggiungiArticolo(articolo1);
//			categoriaServiceInstance.aggiorna(cat1);
//			articoloServiceInstance.inserisciNuovo(articolo1);
//			Articolo a1=new Articolo();
			
//			Articolo a1=new Articolo("Pesca", 300, ordineServiceInstance.caricaSingoloOrdine(2L));
//			Categoria c1= categoriaServiceInstance.caricaSingolaCategoria(1L);
//			c1.aggiungiArticolo(a1);
//			articoloServiceInstance.inserisciNuovo(a1);
//			categoriaServiceInstance.aggiorna(c1);
			
			
			
//			System.out.println(categoriaServiceInstance.caricaSingolaCategoria(1L));
			
//			Articolo a1=new Articolo("Pera",500, ordineServiceInstance.caricaSingoloOrdine(1L));
//			Categoria c1= categoriaServiceInstance.caricaSingolaCategoria(1L);
//			c1.aggiungiArticolo(a1);
//			categoriaServiceInstance.aggiorna(c1);
//			articoloServiceInstance.inserisciNuovo(a1);
			
			System.out.println(articoloServiceInstance
					.sommaTotalePrezzoArticoliLegatiAUnaCategoria(categoriaServiceInstance.caricaSingolaCategoria(1L)));
//			System.out.println(categoriaServiceInstance.TutteLeCategorieDiUnOrdine(ordineServiceInstance.caricaSingoloOrdine(1L)));
//	Articolo a1=new Articolo("Mario",500,ordineServiceInstance.caricaSingoloOrdine(1L));
//			Ordine o1=new Ordine("Marco messina", "via della scafa");
//			articoloServiceInstance.inserisciNuovo(a1);
//			ordineServiceInstance.inserisciNuovo(o1);
	System.out.println("Stampa prova*****************************");
			for (Ordine ordinteItem : ordineServiceInstance.listAll()) {
				System.out.println(ordinteItem);
			}
			System.out.println("Stampa articolo+++++++++++++");
			for (Articolo articolo : articoloServiceInstance.listAll()) {
				System.out.println(articolo);
			}
			System.out.println("Stampa categoria ******************");
			for (Categoria categoria : categoriaServiceInstance.listAll()) {
				System.out.println(categoria);
			}

//			o1.setNomedestinatario("lollo");
//			a1.setDescrizione("Mouse gaming");
//			articoloServiceInstance.aggiorna(a1);
			// ordineServiceInstance.aggiorna(o1);
//			Categoria cat1 = new Categoria("Cibo");

//			categoriaServiceInstance.inserisciNuovo(cat1);
//			categoriaServiceInstance.rimuovi(cat1);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
