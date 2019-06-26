package it.prova.service;

import java.util.List;

import it.prova.model.Ordine;
import it.prova.model.Pizza;

public interface PizzaService {
	public List<Pizza> list();

	public Pizza get(long id);

	public void update(Pizza o);

	public void insert(Pizza o);

	public void delete(Pizza o);

	public List<Pizza> findByExample(Pizza ordineInstance);
	
	List<Pizza> findAllEagerIngredientiAndOrdini();

	Double prezzoSingolaPizza(Pizza pizza);
}
