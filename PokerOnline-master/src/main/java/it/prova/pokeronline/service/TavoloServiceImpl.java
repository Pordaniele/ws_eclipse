package it.prova.pokeronline.service;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;
import it.prova.pokeronline.repository.TavoloRepository;

@Service
public class TavoloServiceImpl implements TavoloService {

	@Autowired
	private TavoloRepository tavoloRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Tavolo> listAllTavoli() {
		return (List<Tavolo>) tavoloRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Tavolo caricaSingolo(Long id) {
		return tavoloRepository.findOne(id);
	}

	@Override
	public void aggiorna(Tavolo tavoloInstance) {
		tavoloRepository.save(tavoloInstance);
	}

	@Override
	public void inserisciNuovo(Tavolo tavoloInstance) {
		tavoloRepository.save(tavoloInstance);
	}

	@Override
	public void rimuovi(Tavolo tavoloInstance) {
		tavoloRepository.delete(tavoloInstance);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Tavolo> findByExample(Tavolo exampleInput) {
		ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(StringMatcher.CONTAINING); 
		// Match string
		// containing
		// pattern
		// .withIgnoreCase();
		return (List<Tavolo>) tavoloRepository.findAll(Example.of(exampleInput, matcher));
	}

	@Override
	public List<Tavolo> findByCreatore(Utente creatore) {
		
		return tavoloRepository.findByCreatore(creatore);
	}

	@Override
	public Tavolo findGiocatori(Long id) {
		
		return tavoloRepository.findGiocatori(id);
	}

	@Override
	public List<Tavolo> findByGiocatori(Set<Utente> item) {
	
		return findByGiocatori(item);
	}

//	@Override
//	public List<Tavolo> findTavoliForCreatoreAndDataAndPartecipanti(String username, String username2, Date data) {
//		return (List<Tavolo>) tavoloRepository.findTavoliForCreatoreAndDataAndPartecipanti(username, username2, data);
//	}

}
