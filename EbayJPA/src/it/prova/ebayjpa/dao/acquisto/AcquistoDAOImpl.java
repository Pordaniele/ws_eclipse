package it.prova.ebayjpa.dao.acquisto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import it.prova.ebayjpa.model.Acquisto;
import it.prova.ebayjpa.model.Ruolo;
@Component
public class AcquistoDAOImpl implements AcquistoDAO{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Acquisto> list() {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
				// non la tabella
				return entityManager.createQuery("from Acquisto").getResultList();
			}

	@Override
	public Acquisto get(long id) {
		Acquisto result = (Acquisto) entityManager.find(Acquisto.class, id);
		return result;
	}

	@Override
	public void update(Acquisto o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Acquisto o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Acquisto o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Acquisto> findByExample(Acquisto o) {
		// TODO Auto-generated method stub
		return null;
	}

}
