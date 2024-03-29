package it.concessionariomoto.dao.motociclo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Component;

import it.concessionariomoto.model.Concessionario;
import it.concessionariomoto.model.Motociclo;

@Component
public class MotocicloDAOImpl implements MotocicloDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Motociclo> list() {
		return entityManager.createQuery("from Motociclo").getResultList();
	}

	@Override
	public Motociclo get(Long id) {
		return entityManager.find(Motociclo.class, id);
	}

	@Override
	public void update(Motociclo o) {
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Motociclo o) {
		entityManager.persist(o);
	}

	@Override
	public void delete(Motociclo o) {
		entityManager.remove(entityManager.merge(o));
	}

	@Override
	public List<Motociclo> findByExample(Motociclo o) {
		Session session = (Session) entityManager.getDelegate();
		Example motocicloExample = Example.create(o).excludeZeroes();
		Criteria criteria = session.createCriteria(Motociclo.class).add(motocicloExample);
		return criteria.list();
	}

	@Override
	public void refresh(Motociclo o) {
		entityManager.refresh(entityManager.merge(o));
	}

	@Override
	public Long numeroMotoATorinoPrima2010() {
		Query q = entityManager.createQuery(
				"select count (m) from Motociclo m join m.concessionario c where c.citta= 'torino' and m.annoImmatricolazione < 2010");
		return (Long) q.getSingleResult();
	}

}
