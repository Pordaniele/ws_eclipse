package it.prova.service;

import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import it.prova.model.Ingrediente;
import it.prova.model.Pizza;
import it.prova.repository.pizza.PizzaRepository;
@Service
@Transactional
public class PizzaServiceImpl implements PizzaService{

	@Autowired
	private PizzaRepository repository;
	
	
	@Override
	public List<Pizza> list() {
		return (List<Pizza>) repository.findAll();

	}

	@Override
	public Pizza get(long id) {
		return repository.findOne(id);

	}

	@Override
	public void update(Pizza o) {
		repository.save(o);
		
	}

	@Override
	public void insert(Pizza o) {
		repository.save(o);
		
	}

	@Override
	public void delete(Pizza o) {
		repository.delete(o);		
		
	}

	@Override
	public List<Pizza> findByExample(Pizza item) {
		ExampleMatcher matcher = ExampleMatcher.matching()     
                .withStringMatcher(StringMatcher.CONTAINING);   // Match string containing pattern   
                //.withIgnoreCase();   
		return (List<Pizza>) repository.findAll(Example.of(item,matcher));
	}

	@Override
	public List<Pizza> findAllEagerIngredientiAndOrdini() {
		
		return (List<Pizza>) repository.findAllEagerIngredientiAndOrdini();
	}

	@Override
	public Double prezzoSingolaPizza(Pizza pizza) {
		Double totale=(double) 0;
		for (Ingrediente ingredienteItem : pizza.getIngredienti()) {
			totale= totale+ingredienteItem.getPrezzo();
		}
		return totale= pizza.getPrezzoBase()+totale;
	}

	
	

}
