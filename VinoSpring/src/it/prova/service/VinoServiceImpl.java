package it.prova.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.dao.VinoDAO;
import it.prova.model.Vino;

@Component
public class VinoServiceImpl implements VinoService {
	@Autowired
	private VinoDAO vinoDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Vino> list() {
		return vinoDAO.list();

	}

	@Transactional(readOnly = true)
	@Override
	public Vino get(Long id) {
		return vinoDAO.get(id);
	}

	@Transactional
	@Override
	public void update(Vino o) {
		vinoDAO.update(o);
	}

	@Transactional
	@Override
	public void insert(Vino o) {
		vinoDAO.insert(o);
	}

	@Transactional
	@Override
	public void delete(Vino o) {
		vinoDAO.delete(o);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Vino> findByExample(Vino o) {
		return vinoDAO.findByExample(o);
	}

}
