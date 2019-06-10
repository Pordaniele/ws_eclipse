package it.prova.gestionemunicipiospringjpa.dao.utente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import it.prova.gestionemunicipiospringjpa.model.Utente;

@Component
public class UtenteDAOImpl implements UtenteDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Utente> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Utente o) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(Utente o) {
		entityManager.persist(o);
	}

	@Override
	public void delete(Utente o) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Utente> findByExample(Utente o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utente executeLogin(String username, String password) {
		Query query = entityManager
				.createQuery("select u FROM Utente u where u.username = :usernameParam and u.password= :passwordParam");
		query.setParameter("usernameParam", username);
		query.setParameter("passwordParam", password);

		return query.getResultList().isEmpty() ? null : (Utente) query.getSingleResult();
	}

}
