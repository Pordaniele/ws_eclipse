package it.prova.dao;

import it.prova.model.Persona;

public interface PersonaDAO extends IbaseDAO<Persona> {
	public void refresh(Persona personaInstance);
}
