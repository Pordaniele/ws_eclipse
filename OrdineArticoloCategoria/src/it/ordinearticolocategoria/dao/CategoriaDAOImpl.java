package it.ordinearticolocategoria.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import it.ordinearticolocategoria.model.Categoria;
import it.ordinearticolocategoria.model.Ordine;

public class CategoriaDAOImpl implements CategoriaDAO{
	private EntityManager entityManager;
	@Override
	public List<Categoria> list() throws Exception {
		return entityManager.createQuery("from Categoria").getResultList();
		
	}

	@Override
	public Categoria get(Long id) throws Exception {
		Categoria result = (Categoria) entityManager.find(Categoria.class, id);
		return result;
	}

	@Override
	public void update(Categoria categoriaInstance) throws Exception {
		if (categoriaInstance == null) {
			throw new Exception("Problema valore in input");
		}

		categoriaInstance = entityManager.merge(categoriaInstance);
	}

	@Override
	public void insert(Categoria categoriaInstance) throws Exception {
		if (categoriaInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(categoriaInstance);
	}

	@Override
	public void delete(Categoria categoriaInstance) throws Exception {
		if (categoriaInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(categoriaInstance));
	}

	@Override
	public List<Categoria> findByExample(Categoria categoriaInstance) throws Exception {
		
		if (categoriaInstance == null) {
			throw new Exception("Problema valore in input");
		}

		Session session = (Session) entityManager.getDelegate();
		Example categoriaExample = Example.create(categoriaInstance).excludeZeroes();
		Criteria criteria = session.createCriteria(Categoria.class).add(categoriaExample);
		return criteria.list();

	}

	

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		
	}

	@Override
	public List<Categoria> TutteLeCategorieDiUnOrdine(Ordine ordineInput) throws Exception {
		return entityManager.createQuery("Select c from Categoria c join fetch c.articoli a join fetch a.ordine ord where ord = " + ordineInput.getId()+" group by c").getResultList();
	}

}
