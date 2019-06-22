package it.prova.ebayjpa.service.categoria;

import java.util.List;

import it.prova.ebayjpa.model.Categoria;

public interface CategoriaService {
	public List<Categoria> list();

	public Categoria get(long id);

	public void update(Categoria o);

	public void insert(Categoria o);

	public void delete(Categoria o);

	public List<Categoria> findByExample(Categoria categoriaInstance);

	public Categoria caricaEager(long id);
}
