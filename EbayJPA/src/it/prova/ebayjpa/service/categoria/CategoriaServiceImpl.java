package it.prova.ebayjpa.service.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebayjpa.dao.categoria.CategoriaDAO;
import it.prova.ebayjpa.model.Categoria;
@Component
public class CategoriaServiceImpl implements CategoriaService{
	@Autowired
	private CategoriaDAO categoriaDAO;
	@Transactional(readOnly = true)
	@Override
	public List<Categoria> list() {
		// TODO Auto-generated method stub
		return categoriaDAO.list();
	}
	@Transactional(readOnly = true)
	@Override
	public Categoria get(long id) {
		return categoriaDAO.get(id);
	}
	@Transactional
	@Override
	public void update(Categoria o) {
		categoriaDAO.update(o);
	}
	@Transactional
	@Override
	public void insert(Categoria o) {
		categoriaDAO.insert(o);
	}
	@Transactional
	@Override
	public void delete(Categoria o) {
		categoriaDAO.delete(o);
		
	}
	@Transactional(readOnly = true)
	@Override
	public List<Categoria> findByExample(Categoria categoriaInstance) {
		return categoriaDAO.findByExample(categoriaInstance);
	}
	@Transactional(readOnly = true)
	@Override
	public Categoria caricaEager(long id) {
		return categoriaDAO.caricaEager(id);
	}

}
