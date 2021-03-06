package it.prova.cartellaesattorialespringjpa.service.cartellaesattoriale;

import java.util.List;

import it.prova.cartellaesattorialespringjpa.model.CartellaEsattoriale;

public interface CartellaEsattorialeService {
	public List<CartellaEsattoriale> listAll() ;

	public CartellaEsattoriale caricaSingolaCartella(Long id);

	public void aggiorna(CartellaEsattoriale cartellaInstance);

	public void inserisciNuovo(CartellaEsattoriale cartellaInstance);

	public void rimuovi(CartellaEsattoriale cartellaInstance);

	public List<CartellaEsattoriale> findByExample(CartellaEsattoriale example);
	
}
