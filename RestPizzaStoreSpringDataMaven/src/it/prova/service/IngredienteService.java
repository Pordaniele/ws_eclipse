package it.prova.service;

import java.util.List;

import it.prova.model.Ingrediente;


public interface IngredienteService {

	public List<Ingrediente> list();

	public Ingrediente get(long id);

	public void update(Ingrediente o);

	public void insert(Ingrediente o);

	public void delete(Ingrediente o);

	public List<Ingrediente> findByExample(Ingrediente ingredienteInstance);
	
	List<Ingrediente> findAllEagerPizze();
}
