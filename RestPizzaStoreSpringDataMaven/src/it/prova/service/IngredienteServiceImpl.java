package it.prova.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import it.prova.model.Ingrediente;
import it.prova.repository.ingrediente.IngredienteRepository;
@Service
@Transactional
public class IngredienteServiceImpl implements IngredienteService{

	@Autowired
	private IngredienteRepository repository;
	
	
	@Override
	public List<Ingrediente> list() {
		return (List<Ingrediente>) repository.findAll();

	}
	
	@Override
	public Ingrediente get(long id) {
		return repository.findOne(id);

	}

	@Override
	public void update(Ingrediente o) {
		repository.save(o);
		
	}

	@Override
	public void insert(Ingrediente o) {
		repository.save(o);		
	}

	@Override
	public void delete(Ingrediente o) {
		repository.delete(o);		
	}

	@Override
	public List<Ingrediente> findByExample(Ingrediente item) {
		ExampleMatcher matcher = ExampleMatcher.matching()     
                .withStringMatcher(StringMatcher.CONTAINING);   // Match string containing pattern   
                //.withIgnoreCase();   
		return (List<Ingrediente>) repository.findAll(Example.of(item,matcher));
	}

	@Override
	public List<Ingrediente> findAllEagerPizze() {
		return (List<Ingrediente>) repository.findAllEagerPizze();
	}


}
