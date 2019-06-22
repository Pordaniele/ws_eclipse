package it.prova.ebayjpa.dao.annuncio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Example.PropertySelector;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;

import it.prova.ebayjpa.model.Annuncio;
import it.prova.ebayjpa.model.Categoria;
import it.prova.ebayjpa.model.Utente;
@Component
public class AnnuncioDAOImpl implements AnnuncioDAO{
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> list() {
		// dopo la from bisogna specificare il nome dell'oggetto (lettera maiuscola) e
		// non la tabella
		return entityManager.createQuery("from Annuncio").getResultList();
	}


	@Override
	public Annuncio get(long id) {
		Annuncio result = (Annuncio) entityManager.find(Annuncio.class, id);
		return result;
	}

	@Override
	public void update(Annuncio o) {
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Annuncio o) {
		entityManager.persist(o);
	}

	@Override
	public void delete(Annuncio o) {
		entityManager.remove(entityManager.merge(o));
	}


	@Override
	public List<Annuncio> findByExample(Annuncio annuncioInstance) {
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

		Example annuncioExample = Example.create(annuncioInstance).setPropertySelector(ps).enableLike(MatchMode.START);
		Criteria criteria = session.createCriteria(Annuncio.class).add(annuncioExample);
		return criteria.list();
	}


//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Annuncio> findByExampleEager(Annuncio annuncioInput) {
//		Query query = entityManager
//				.createQuery("select distinct a FROM Annuncio a left join fetch a.categorie c where a.testoAnnuncio like :descrizione and c in (:listapersone)");
//		query.setParameter("descrizione", '%'+annuncioInput.getTestoAnnuncio()+'%');
//		query.setParameter("listapersone", annuncioInput.getCategorie());
//		
//		return  (ArrayList<Annuncio>) query.getResultList();
////		return (Utente) query.getSingleResult();
//	
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> findByExampleEager(Annuncio annuncioInput) {
		Query query = entityManager
				.createQuery("select distinct a FROM Annuncio a left join fetch a.categorie c where a.testoAnnuncio like :descrizione and ApertoChiuso = 1 and a.prezzo <= :prezzo and c in (:listapersone)");
		query.setParameter("descrizione", '%'+annuncioInput.getTestoAnnuncio()+'%');
		query.setParameter("listapersone", annuncioInput.getCategorie());
		query.setParameter("prezzo", annuncioInput.getPrezzo());
		return  (ArrayList<Annuncio>) query.getResultList();

	
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Annuncio> cercaAnnuncioPerCategoria(Categoria categoria) {
		Query query = entityManager
				.createQuery("select a FROM Annuncio a left join fetch a.categorie c where c.id = :id");
		query.setParameter("id", categoria.getId());
		return  (ArrayList<Annuncio>) query.getResultList();
	}
	
	@Override
	public Annuncio caricaEager(long id) {
		Query query = entityManager
				.createQuery("select a from Annuncio a left join fetch a.utente join fetch a.categorie where a.id = :id");
		query.setParameter("id", id);
		return query.getResultList().isEmpty() ? null : (Annuncio) query.getSingleResult();
	}
}
