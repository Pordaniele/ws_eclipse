package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import it.prova.model.Ingrediente;
import it.prova.model.Ordine;
import it.prova.model.Pizza;
import it.prova.repository.ordine.OrdineRepository;

@Service
public class OrdineServiceImpl implements OrdineService{
	@Autowired
	private OrdineRepository repository;

	@Override
	public List<Ordine> list() {
		return (List<Ordine>) repository.findAll();

	}

	@Override
	public Ordine get(long id) {
		return repository.findOne(id);

	}

	@Override
	public void update(Ordine o) {
		repository.save(o);		
	}

	@Override
	public void insert(Ordine o) {
		repository.save(o);		
		
	}

	@Override
	public void delete(Ordine o) {
		repository.delete(o);		
		
	}

	@Override
	public List<Ordine> findByExample(Ordine item) {
		ExampleMatcher matcher = ExampleMatcher.matching()     
                .withStringMatcher(StringMatcher.CONTAINING);   // Match string containing pattern   
                //.withIgnoreCase();   
		return (List<Ordine>) repository.findAll(Example.of(item,matcher));
	}

	@Override
	public List<Ordine> findALLEagerPizze() {
		
		return (List<Ordine>) repository.findALLEagerPizze();
	}

	@Override
	public Ordine cercaConPizza(Long id) {
		
		return repository.cercaConPizza(id);
	}

	@Override
	public Double calcolaTotaleOrdine(Long id) {
		Ordine ordine=repository.cercaConPizza(id);
		double totale=(double)0;
		for (Pizza item : ordine.getPizze()) {
			totale=totale+item.getPrezzoBase();
			for (Ingrediente ingredienteItem : item.getIngredienti()) {
				totale=totale+ingredienteItem.getPrezzo();
			}
		}
		return totale;
	}
	
	

}
