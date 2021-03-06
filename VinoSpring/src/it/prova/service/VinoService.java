package it.prova.service;

import java.util.List;

import it.prova.model.Vino;

public interface VinoService {
	public List<Vino> list();

	public Vino get(Long id);

	public void update(Vino o);

	public void insert(Vino o);

	public void delete(Vino o);

	public List<Vino> findByExample(Vino o);
}
