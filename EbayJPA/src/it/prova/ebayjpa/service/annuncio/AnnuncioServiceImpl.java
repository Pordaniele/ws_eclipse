package it.prova.ebayjpa.service.annuncio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebayjpa.dao.annuncio.AnnuncioDAO;
import it.prova.ebayjpa.model.Annuncio;

@Component
public class AnnuncioServiceImpl implements AnnuncioService {
	@Autowired
	private AnnuncioDAO annuncioDAO;
	@Transactional(readOnly = true)
	@Override
	public List<Annuncio> list() {
		// TODO Auto-generated method stub
		return annuncioDAO.list();
	}
	@Transactional(readOnly = true)
	@Override
	public Annuncio get(long id) {
		return annuncioDAO.get(id);
	}
	@Transactional
	@Override
	public void update(Annuncio o) {
		annuncioDAO.update(o);
	}
	@Transactional
	@Override
	public void insert(Annuncio o) {
		annuncioDAO.insert(o);
	}
	@Transactional
	@Override
	public void delete(Annuncio o) {
		annuncioDAO.delete(o);

	}
	@Transactional(readOnly = true)
	@Override
	public List<Annuncio> findByExample(Annuncio annuncioInstance) {
		return annuncioDAO.findByExample(annuncioInstance);
	}
	@Transactional(readOnly = true)
	@Override
	public List<Annuncio> findByExampleEager(Annuncio annuncioInput) {
		return annuncioDAO.findByExampleEager(annuncioInput);
	}
	@Transactional(readOnly = true)
	@Override
	public Annuncio caricaEager(long id) {
		return annuncioDAO.caricaEager(id);
	}

}
