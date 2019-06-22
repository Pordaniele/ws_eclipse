package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.model.Autore;
import it.prova.repository.AutoreRepository;

@Service
public class AutoreServiceImpl implements AutoreService {

	@Autowired
	private AutoreRepository autoreRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Autore> listAllAutori() {
		return (List<Autore>) autoreRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Autore caricaSingolo(Long id) {
		return autoreRepository.findOne(id);
	}

	@Override
	public void aggiorna(Autore autoreInstance) {
		autoreRepository.save(autoreInstance);
	}

	@Override
	public void inserisciNuovo(Autore autoreInstance) {
		autoreRepository.save(autoreInstance);
	}

	@Override
	public void rimuovi(Autore autoreInstance) {
		autoreRepository.delete(autoreInstance);

	}

	@Transactional(readOnly = true)
	public List<Autore> findByExample(Autore exampleInput) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING); // Match string
																										// containing
																										// pattern
		// .withIgnoreCase();
		return (List<Autore>) autoreRepository.findAll(Example.of(exampleInput, matcher));
	}

}
