package it.prova.dao;

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

import it.prova.model.Persona;

@Component
public class PersonaDAOImpl implements PersonaDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Persona> list() {
		return em.createQuery("from Persona").getResultList();
	}

	@Override
	public Persona get(Long id) {
		return em.find(Persona.class, id);
	}

	@Override
	public void update(Persona o) {
		o = em.merge(o);
	}

	@Override
	public void insert(Persona o) {
		em.persist(o);
	}
	
	public void refresh(Persona personaInstance) {
		em.refresh(em.merge(personaInstance));
	}


	@Override
	public void delete(Persona o) {
		em.remove(em.merge(o));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Persona> findByExample(Persona input) {
		Session session = (Session) em.getDelegate();
		
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
		
		Example personaExample = Example.create(input).setPropertySelector(ps);
		Criteria criteria = session.createCriteria(Persona.class).add(personaExample);
		return criteria.list();
	}

}
