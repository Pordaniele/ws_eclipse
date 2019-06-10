package it.ordinearticolocategoria.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.ordinearticolocategoria.dao.ArticoloDAO;
import it.ordinearticolocategoria.dao.EntityManagerUtil;
import it.ordinearticolocategoria.model.Articolo;
import it.ordinearticolocategoria.model.Categoria;

public class ArticoloServiceImpl implements ArticoloService {
	private ArticoloDAO articoloDAO;

	@Override
	public List<Articolo> listAll() throws Exception {
		try {
			// uso l'injection per il dao
			articoloDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return articoloDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Articolo caricaSingoloArticolo(Long id) throws Exception {
		try {
			// uso l'injection per il dao
			articoloDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return articoloDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void aggiorna(Articolo articoloInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			articoloDAO.update(articoloInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Override
	public void inserisciNuovo(Articolo articoloInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			articoloDAO.insert(articoloInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void rimuovi(Articolo articoloInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			articoloDAO.delete(articoloInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Articolo> findByExample(Articolo example) throws Exception {
		try {
			// uso l'injection per il dao
			articoloDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return articoloDAO.findByExample(example);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void setArticoloDAO(ArticoloDAO articoloDAO) {
		this.articoloDAO = articoloDAO;

	}

	@Override
	public List<Articolo> sommaTotalePrezzoArticoliLegatiAUnaCategoria(Categoria categoriaInput) throws Exception {
		try {
			// uso l'injection per il dao
			articoloDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return articoloDAO.sommaTotalePrezzoArticoliLegatiAUnaCategoria(categoriaInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
	}
	}
}
