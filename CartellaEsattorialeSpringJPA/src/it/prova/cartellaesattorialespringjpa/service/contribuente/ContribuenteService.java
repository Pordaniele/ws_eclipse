package it.prova.cartellaesattorialespringjpa.service.contribuente;

import java.util.List;

import it.prova.cartellaesattorialespringjpa.model.Contribuente;


public interface ContribuenteService {

	
	public List<Contribuente> listAll() ;

	public Contribuente caricaSingoloContribuente(Long id);

	public void aggiorna(Contribuente contribuenteInstance);

	public void inserisciNuovo(Contribuente contribuenteInstance);

	public void rimuovi(Contribuente contribuenteInstance);

	public List<Contribuente> findByExample(Contribuente example);
	
}
