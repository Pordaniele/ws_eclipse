package it.prova.pokeronline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.repository.UtenteRepository;

@Service
public class UtenteServiceImpl implements UtenteService {

	@Autowired
	private UtenteRepository utenteRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Utente> listAllUtenti() {
		return (List<Utente>) utenteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Utente caricaSingolo(Long id) {
		return utenteRepository.findOne(id);
	}

	@Override
	public void aggiorna(Utente utenteInstance) {
		utenteRepository.save(utenteInstance);
	}

	@Override
	public void inserisciNuovo(Utente utenteInstance) {
		utenteRepository.save(utenteInstance);
	}

	@Override
	public void rimuovi(Utente utenteInstance) {
		utenteRepository.delete(utenteInstance);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Utente> findByExample(Utente exampleInput) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING); 
		// Match string
		// containing
		// pattern
		// .withIgnoreCase();
		return (List<Utente>) utenteRepository.findAll(Example.of(exampleInput, matcher));
	}

	@Override
	public Utente findByUsernameAndPassword(String username, String password) {
		
		return utenteRepository.findByUsernameAndPassword(username, password);
	}

	@Override
	public Utente caricaUtentePerUsernamePasswordeRuolo(Long id) {
		return utenteRepository.caricaUtentePerUsernamePasswordeRuolo(id);
	}

	@Override
	public Utente findByUsername(String username) {
		return utenteRepository.findByUsername(username);
	}

}
