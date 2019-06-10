package it.manytomanyjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import it.manytomanyjpa.model.Ruolo;

public class RuoloDAOImpl implements RuoloDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Ruolo> list() throws Exception {
		return entityManager.createQuery(" from Ruolo ").getResultList();
		}
	

	@Override
	public Ruolo get(long id) throws Exception {
		Ruolo result = (Ruolo) entityManager.find(Ruolo.class, id);
		return result;
	}

	@Override
	public void update(Ruolo ruoloInstance) throws Exception {
		if (ruoloInstance == null) {
			throw new Exception("Problema valore in input");
		}

		ruoloInstance = entityManager.merge(ruoloInstance);

	}

	@Override
	public void insert(Ruolo o) throws Exception {
		if (o == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(o);

	}

	@Override
	public void delete(Ruolo ruoloInstance) throws Exception {
		if (ruoloInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(ruoloInstance));

	}

	@Override
	public List<Ruolo> findByExample(Ruolo ruoloInstance) throws Exception {
		if (ruoloInstance == null) {
			throw new Exception("Problema valore in input");
		}

		Session session = (Session) entityManager.getDelegate();
		Example ruoloExample = Example.create(ruoloInstance).excludeZeroes();
		Criteria criteria = session.createCriteria(Ruolo.class).add(ruoloExample);
		return criteria.list();
	}
	

}
