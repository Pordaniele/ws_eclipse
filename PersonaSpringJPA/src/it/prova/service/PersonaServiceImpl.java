package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.dao.PersonaDAO;
import it.prova.model.Persona;

@Component
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDAO personaDAO;

	@Transactional(readOnly = true)
	public List<Persona> cercaPersonaByExample(Persona example) {
		return personaDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	public Persona caricaSingolaPersona(long idPersonaInput) {
		return personaDAO.get(idPersonaInput);
	}
	@Transactional
	@Override
	public void aggiorna(Persona personaInstance) {
		personaDAO.update(personaInstance);
	}
	@Transactional
	@Override
	public void inserisciNuovo(Persona personaInstance) {
		personaDAO.insert(personaInstance);
	}
	@Transactional
	@Override
	public void rimuovi(Persona personaInstance) {
		personaDAO.delete(personaInstance);
	}

	@Override
	public void refresh(Persona personaInstance) {
		personaDAO.refresh(personaInstance);
	
	}

	@Override
	public List<Persona> list() {
		return personaDAO.list();
		
	}

}
