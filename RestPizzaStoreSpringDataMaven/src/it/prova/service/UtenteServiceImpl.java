package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import it.prova.model.Cliente;
import it.prova.model.Utente;
import it.prova.repository.cliente.ClienteRepository;
import it.prova.repository.utente.UtenteRepository;

@Service
public class UtenteServiceImpl implements UtenteService{

	@Autowired
	private UtenteRepository repository;
	
	@Override
	public List<Utente> list() {
		return (List<Utente>) repository.findAll();

	}

	@Override
	public Utente get(long id) {
		return repository.findOne(id);

	}

	@Override
	public void update(Utente o) {
		repository.save(o);
		
	}

	@Override
	public void insert(Utente o) {
		repository.save(o);
		
	}

	@Override
	public void delete(Utente o) {
		repository.delete(o);		
		
	}

	@Override
	public List<Utente> findByExample(Utente item) {
		ExampleMatcher matcher = ExampleMatcher.matching()     
                .withStringMatcher(StringMatcher.CONTAINING);   // Match string containing pattern   
                //.withIgnoreCase();   
		return (List<Utente>) repository.findAll(Example.of(item,matcher));
	}

}
