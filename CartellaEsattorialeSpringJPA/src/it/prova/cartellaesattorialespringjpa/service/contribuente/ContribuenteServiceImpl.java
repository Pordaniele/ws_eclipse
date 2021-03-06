package it.prova.cartellaesattorialespringjpa.service.contribuente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.cartellaesattorialespringjpa.dao.contribuente.ContribuenteDAO;
import it.prova.cartellaesattorialespringjpa.model.Contribuente;

@Component
public class ContribuenteServiceImpl implements ContribuenteService {
	@Autowired
	private ContribuenteDAO contribuenteDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Contribuente> listAll() {
		return contribuenteDAO.list();
	}

	@Transactional(readOnly = true)
	@Override
	public Contribuente caricaSingoloContribuente(Long id) {
		return contribuenteDAO.get(id);
	}

	@Transactional
	@Override
	public void aggiorna(Contribuente contribuenteInstance) {
		contribuenteDAO.update(contribuenteInstance);
	}

	@Transactional
	@Override
	public void inserisciNuovo(Contribuente contribuenteInstance) {
		contribuenteDAO.insert(contribuenteInstance);
	}

	@Transactional
	@Override
	public void rimuovi(Contribuente contribuenteInstance) {
		contribuenteDAO.delete(contribuenteInstance);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Contribuente> findByExample(Contribuente example) {
		return contribuenteDAO.findByExample(example);
	}
}
