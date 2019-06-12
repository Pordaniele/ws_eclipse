package it.prova.ebayjpa.dao.ruolo;

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

import it.prova.ebayjpa.model.Ruolo;


@Component
public class RuoloDAOImpl implements RuoloDAO{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Ruolo> list() {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Ruolo").getResultList();
	}


	@Override
	public Ruolo get(long id) {
		Ruolo result = (Ruolo) entityManager.find(Ruolo.class, id);
		return result;
	}

	@Override
	public void update(Ruolo o) {
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Ruolo o) {
		entityManager.persist(o);
		
	}

	@Override
	public void delete(Ruolo o) {
		entityManager.remove(entityManager.merge(o));
		
	}

	@Override
	public List<Ruolo> findByExample(Ruolo ruoloInstance) {
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

		Example ruoloExample = Example.create(ruoloInstance).setPropertySelector(ps);
		Criteria criteria = session.createCriteria(Ruolo.class).add(ruoloExample);
		return criteria.list();
	}
	
	
	
}
