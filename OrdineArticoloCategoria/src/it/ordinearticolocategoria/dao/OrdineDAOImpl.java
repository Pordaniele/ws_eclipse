package it.ordinearticolocategoria.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;

import it.ordinearticolocategoria.model.Categoria;
import it.ordinearticolocategoria.model.Ordine;

public class OrdineDAOImpl implements OrdineDAO{
	private EntityManager entityManager;

	@Override
	public List<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine").getResultList();
	}

	

	@Override
	public Ordine get(Long id) throws Exception {
		Ordine result = (Ordine) entityManager.find(Ordine.class, id);
		return result;
	}

	@Override
	public void update(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null) {
			throw new Exception("Problema valore in input");
		}

		ordineInstance = entityManager.merge(ordineInstance);
	}


	@Override
	public void insert(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(ordineInstance);
	}

	@Override
	public void delete(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(ordineInstance));
	}

	@Override
	public List<Ordine> findByExample(Ordine ordineInstance) throws Exception {
		if (ordineInstance == null) {
			throw new Exception("Problema valore in input");
		}

		Session session = (Session) entityManager.getDelegate();
		Example ordineExample = Example.create(ordineInstance).excludeZeroes();
		Criteria criteria = session.createCriteria(Ordine.class).add(ordineExample);
		return criteria.list();

	}
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}



	@Override
	public List<Ordine> ordineEffetturatiPerCategoria(Categoria categoria) throws Exception {
		return entityManager.createQuery("Select o from Ordine o join fetch o.articoli a join fetch a.categorie cat where cat = " + categoria.getId()+" group by o").getResultList();
	}



	

}
