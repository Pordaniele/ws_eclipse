package it.prova.service;

import java.util.List;

import it.prova.model.Ruolo;

public interface RuoloService {
	public List<Ruolo> list();

	public Ruolo get(long id);

	public void update(Ruolo o);

	public void insert(Ruolo o);

	public void delete(Ruolo o);

	public List<Ruolo> findByExample(Ruolo ruoloInstance);
}
