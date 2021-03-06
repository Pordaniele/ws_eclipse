package it.prova.cartellaesattorialespringjpa.dao.contribuente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.prova.cartellaesattorialespringjpa.model.Contribuente;

@Component
public class ContribuenteDAOImpl implements ContribuenteDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Contribuente> list() {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
				// non la tabella
				return entityManager.createQuery("from Contribuente").getResultList();
			}

	@Override
	public Contribuente get(long id) {
		Contribuente result = (Contribuente) entityManager.find(Contribuente.class, id);
		return result;
	}

	@Override
	public void update(Contribuente o) {
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Contribuente o) {
		entityManager.persist(o);
	}

	@Override
	public void delete(Contribuente o) {
		entityManager.remove(entityManager.merge(o));
	}

	@Override
	public List<Contribuente> findByExample(Contribuente contribuenteInstance) {
		Session session = (Session) entityManager.getDelegate();

		@SuppressWarnings("serial")
		PropertySelector ps = new PropertySelector() {
			@Override
			public boolean include(Object object, String propertyName, Type type) {
				if (object == null)
					return false;
				// String
				if (object instanceof String)
					return StringUtils.isNotBlank((String) object);
				// Number
				if (object instanceof Integer)
					return ((Integer) object) != 0;
				return true;
			}
		};

		Example contribuenteExample = Example.create(contribuenteInstance).setPropertySelector(ps);
		Criteria criteria = session.createCriteria(Contribuente.class).add(contribuenteExample);
		return criteria.list();
	}
	
	
}
