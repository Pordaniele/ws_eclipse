package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import it.prova.model.Cliente;
import it.prova.repository.cliente.ClienteRepository;
@Service
public class ClienteServiceImpl implements ClienteService{

	
	@Autowired
	private ClienteRepository repository;
	
	@Override
	public List<Cliente> list() {
		return (List<Cliente>) repository.findAll();

	}

	@Override
	public Cliente get(long id) {
		return repository.findOne(id);
	}

	@Override
	public void update(Cliente o) {
		repository.save(o);
		
	}

	@Override
	public void insert(Cliente o) {
		repository.save(o);		
	}

	@Override
	public void delete(Cliente o) {
		repository.delete(o);		
	}

	@Override
	public List<Cliente> findByExample(Cliente item) {
		ExampleMatcher matcher = ExampleMatcher.matching()     
                .withStringMatcher(StringMatcher.CONTAINING);   // Match string containing pattern   
                //.withIgnoreCase();   
		return (List<Cliente>) repository.findAll(Example.of(item,matcher));
	}

	@Override
	public List<Cliente> findAllEagerOrdini() {
		
		return (List<Cliente>) repository.findAllEagerOrdini();
	}

	@Override
	public Cliente caricaEager(Long id) {
		return repository.caricaEager(id);
	}

}
