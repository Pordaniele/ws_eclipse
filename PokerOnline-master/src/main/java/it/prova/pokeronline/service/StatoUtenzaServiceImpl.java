package it.prova.pokeronline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pokeronline.model.StatoUtenza;
import it.prova.pokeronline.repository.StatoUtenzaRepository;

@Service
public class StatoUtenzaServiceImpl implements StatoUtenzaService {

	@Autowired
	private StatoUtenzaRepository statoUtenzaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<StatoUtenza> listAllStatiUtenza() {
		return (List<StatoUtenza>) statoUtenzaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public StatoUtenza caricaSingolo(Long id) {
		return statoUtenzaRepository.findOne(id);
	}

	@Override
	public void aggiorna(StatoUtenza statoUtenzaInstance) {
		statoUtenzaRepository.save(statoUtenzaInstance);
	}

	@Override
	public void inserisciNuovo(StatoUtenza statoUtenzaInstance) {
		statoUtenzaRepository.save(statoUtenzaInstance);
	}

	@Override
	public void rimuovi(StatoUtenza statoUtenzaInstance) {
		statoUtenzaRepository.delete(statoUtenzaInstance);
	}

	@Override
	@Transactional(readOnly = true)
	public List<StatoUtenza> findByExample(StatoUtenza exampleInput) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING);
		// Match string
		// containing
		// pattern
		// .withIgnoreCase();
		return (List<StatoUtenza>) statoUtenzaRepository.findAll(Example.of(exampleInput, matcher));
	}

}
