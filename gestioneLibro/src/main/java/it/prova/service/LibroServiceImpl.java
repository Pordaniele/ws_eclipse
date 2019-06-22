package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.model.Autore;
import it.prova.model.Libro;
import it.prova.repository.LibroRepository;

@Service
public class LibroServiceImpl implements LibroService {

	@Autowired
	private LibroRepository libroRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Libro> listAllLibri() {

		return (List<Libro>) libroRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Libro caricaSingolo(Long id) {
		return libroRepository.findOne(id);
	}

	@Override
	public void aggiorna(Libro libroInstance) {
		libroRepository.save(libroInstance);

	}

	@Override
	public void inserisciNuovo(Libro libroInstance) {
		libroRepository.save(libroInstance);
	}

	@Override
	public void rimuovi(Libro libroInstance) {
		libroRepository.delete(libroInstance);

	}
	@Transactional(readOnly = true)
	@Override
	public List<Libro> findByExample(Libro example) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING); // Match string
		
		// .withIgnoreCase();
		return (List<Libro>) libroRepository.findAll(Example.of(example, matcher));

	}

	@Override
	public Libro caricaEager(Long id) {
		
		return libroRepository.caricaEager(id);
	}

}
