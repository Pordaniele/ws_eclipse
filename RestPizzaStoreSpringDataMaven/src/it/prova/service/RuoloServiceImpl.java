package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import it.prova.model.Cliente;
import it.prova.model.Ruolo;
import it.prova.repository.cliente.ClienteRepository;
import it.prova.repository.ruolo.RuoloRepository;

@Service
public class RuoloServiceImpl implements RuoloService{

	
	@Autowired
	private RuoloRepository repository;

	@Override
	public List<Ruolo> list() {
		return (List<Ruolo>) repository.findAll();

	}

	@Override
	public Ruolo get(long id) {
		return repository.findOne(id);

	}

	@Override
	public void update(Ruolo o) {
		repository.save(o);
		
	}

	@Override
	public void insert(Ruolo o) {
		repository.save(o);
		
	}

	@Override
	public void delete(Ruolo o) {
		repository.delete(o);		
		
	}

	@Override
	public List<Ruolo> findByExample(Ruolo item) {
		ExampleMatcher matcher = ExampleMatcher.matching()     
                .withStringMatcher(StringMatcher.CONTAINING);   // Match string containing pattern   
                //.withIgnoreCase();   
		return (List<Ruolo>) repository.findAll(Example.of(item,matcher));
	}

	
}
