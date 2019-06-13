package it.prova.ebayjpa.service.acquisto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebayjpa.dao.acquisto.AcquistoDAO;
import it.prova.ebayjpa.model.Acquisto;

@Component
public class AcquistoServiceImpl implements AcquistoService {
	@Autowired
	private AcquistoDAO acquistoDAO;
	@Transactional(readOnly = true)
	@Override
	public List<Acquisto> list() {
		// TODO Auto-generated method stub
		return acquistoDAO.list();
	}
	@Transactional(readOnly = true)
	@Override
	public Acquisto get(long id) {
		return acquistoDAO.get(id);
	}
	@Transactional
	@Override
	public void update(Acquisto o) {
		acquistoDAO.update(o);
	}
	@Transactional
	@Override
	public void insert(Acquisto o) {
		acquistoDAO.insert(o);
	}
	@Transactional
	@Override
	public void delete(Acquisto o) {
		acquistoDAO.delete(o);

	}
	@Transactional(readOnly = true)
	@Override
	public List<Acquisto> findByExample(Acquisto acquistoInstance) {
		return acquistoDAO.findByExample(acquistoInstance);
	}

}
