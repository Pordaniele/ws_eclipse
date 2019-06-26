package it.prova.service;

import java.util.List;

import it.prova.model.Ingrediente;
import it.prova.model.Ordine;

public interface OrdineService {
	public List<Ordine> list();

	public Ordine get(long id);

	public void update(Ordine o);

	public void insert(Ordine o);

	public void delete(Ordine o);

	public List<Ordine> findByExample(Ordine ordineInstance);
	
	List<Ordine> findALLEagerPizze();
	
	Ordine cercaConPizza(Long id);

	Double calcolaTotaleOrdine(Long id);
}
