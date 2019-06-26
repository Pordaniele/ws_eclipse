package it.prova.service;

import java.util.List;

import it.prova.model.Cliente;



public interface ClienteService {
public List<Cliente> list();
	
	public Cliente get(long id);
	
	public void update(Cliente o);
	
	public void insert(Cliente o);
	
	public void delete(Cliente o);
	
	public List<Cliente> findByExample(Cliente ruoloInstance);
	
	List<Cliente> findAllEagerOrdini();

	Cliente caricaEager (Long id);

}
