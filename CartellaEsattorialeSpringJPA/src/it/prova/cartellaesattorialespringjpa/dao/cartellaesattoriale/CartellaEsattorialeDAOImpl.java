package it.prova.cartellaesattorialespringjpa.dao.cartellaesattoriale;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.criterion.MatchMode;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.prova.cartellaesattorialespringjpa.model.CartellaEsattoriale;

@Component
public class CartellaEsattorialeDAOImpl implements CartellaEsattorialeDAO{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<CartellaEsattoriale> list() {
		return entityManager.createQuery("from CartellaEsattoriale").getResultList();
	}

	@Override
	public CartellaEsattoriale get(long id) {
		CartellaEsattoriale result = (CartellaEsattoriale) entityManager.find(CartellaEsattoriale.class, id);
		return result;
	}

	@Override
	public void update(CartellaEsattoriale o) {
		o = entityManager.merge(o);
	}

	@Override
	public void insert(CartellaEsattoriale o) {
		entityManager.persist(o);
	}

	@Override
	public void delete(CartellaEsattoriale o) {
		entityManager.remove(entityManager.merge(o));
	}

	@Override
	public List<CartellaEsattoriale> findByExample(CartellaEsattoriale cartellaInstance) {
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

		Criteria cartellaCriteria = session.createCriteria(CartellaEsattoriale.class);
		Example cartellaExample = Example.create(cartellaInstance).setPropertySelector(ps).enableLike(MatchMode.START);
		if (cartellaInstance.getContribuente() != null) {
			cartellaCriteria.createCriteria("contribuente").add(Example.create(cartellaInstance.getContribuente()));
		}

		cartellaCriteria.add(cartellaExample);
		return cartellaCriteria.list();

	}
	
	
}
