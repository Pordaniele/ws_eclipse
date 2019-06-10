package it.ordinearticolocategoria.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;

import it.ordinearticolocategoria.model.Articolo;
import it.ordinearticolocategoria.model.Categoria;

public class ArticoloDAOImpl implements ArticoloDAO{
private EntityManager entityManager;
	@Override
	public List<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo").getResultList();
	
	}

	@Override
	public Articolo get(Long id) throws Exception {
		Articolo result = (Articolo) entityManager.find(Articolo.class, id);
		return result;
	}

	@Override
	public void update(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}

		articoloInstance = entityManager.merge(articoloInstance);
	}

	@Override
	public void insert(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.persist(articoloInstance);
	}


	@Override
	public void delete(Articolo articoloInstance) throws Exception {
		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}

		entityManager.remove(entityManager.merge(articoloInstance));
	}

	@Override
	public List<Articolo> findByExample(Articolo articoloInstance) throws Exception {

		if (articoloInstance == null) {
			throw new Exception("Problema valore in input");
		}

		Session session = (Session) entityManager.getDelegate();
		Example articoloExample = Example.create(articoloInstance).excludeZeroes();
		Criteria criteria = session.createCriteria(Articolo.class).add(articoloExample);
		return criteria.list();

	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Articolo> sommaTotalePrezzoArticoliLegatiAUnaCategoria(Categoria categoriaInput) throws Exception {
		return entityManager.createQuery("select sum(a.prezzosingolo) from Articolo a join a.categorie c where c = " +categoriaInput.getId()).getResultList();
	}

}
