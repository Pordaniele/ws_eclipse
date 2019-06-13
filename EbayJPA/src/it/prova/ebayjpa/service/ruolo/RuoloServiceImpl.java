package it.prova.ebayjpa.service.ruolo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebayjpa.dao.ruolo.RuoloDAO;
import it.prova.ebayjpa.model.Ruolo;
@Component
public class RuoloServiceImpl implements RuoloService{

	@Autowired
	private RuoloDAO ruoloDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Ruolo> list() {
		return ruoloDAO.list();
	}

	@Transactional(readOnly = true)
	public Ruolo get(long id) {
		return ruoloDAO.get(id);
	}

	@Transactional
	@Override
	public void update(Ruolo o) {
		ruoloDAO.update(o);
	}

	@Transactional
	@Override
	public void insert(Ruolo o) {
		ruoloDAO.insert(o);
	}

	@Transactional
	@Override
	public void delete(Ruolo o) {
		ruoloDAO.delete(o);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Ruolo> findByExample(Ruolo ruoloInstance) {
		return ruoloDAO.findByExample(ruoloInstance);
	}

}
