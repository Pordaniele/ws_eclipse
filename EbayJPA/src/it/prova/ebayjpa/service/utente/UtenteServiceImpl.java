package it.prova.ebayjpa.service.utente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebayjpa.dao.annuncio.AnnuncioDAO;
import it.prova.ebayjpa.dao.utente.UtenteDAO;
import it.prova.ebayjpa.dto.AcquistoDTO;
import it.prova.ebayjpa.model.Acquisto;
import it.prova.ebayjpa.model.Annuncio;
import it.prova.ebayjpa.model.Utente;

@Component
public class UtenteServiceImpl implements UtenteService{

	@PersistenceContext
	private EntityManager entityManager;
	@Autowired
	private UtenteDAO utenteDAO;
	@Autowired
	private AnnuncioDAO annuncioDAO;

	@Transactional(readOnly = true)
	public List<Utente> listAllUtenti() {
		return utenteDAO.list();
	}

	@Transactional(readOnly = true)
	public Utente caricaSingoloUtente(Long id) {
		return utenteDAO.get(id);
	}

	@Transactional
	public void aggiorna(Utente utenteInstance) {
		utenteDAO.update(utenteInstance);
	}

	@Transactional
	public void inserisciNuovo(Utente utenteInstance) {
		utenteDAO.insert(utenteInstance);
	}

	@Transactional
	public void rimuovi(Utente utenteInstance) {
		utenteDAO.delete(utenteInstance);
	}

	@Transactional(readOnly = true)
	public List<Utente> findByExample(Utente example) {
		return utenteDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public Utente eseguiAccesso(String username, String password) {
		return utenteDAO.executeLogin(username, password);
	}

	@Transactional(readOnly = true)
	@Override
	public Utente executeFetchLogin(String username, String password) {
		return utenteDAO.executeFetchLogin(username, password);
	}

	@Transactional(readOnly = true)
	@Override
	public Utente caricaEager(long id) {
		return utenteDAO.caricaEager(id);
	}
	@Transactional(readOnly = true)
	@Override
	public Utente caricaEagerAnnunci(long id) {
		return utenteDAO.caricaEagerAnnunci(id);
	}


	
}
