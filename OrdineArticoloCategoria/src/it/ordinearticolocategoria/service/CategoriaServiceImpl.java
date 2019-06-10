package it.ordinearticolocategoria.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.ordinearticolocategoria.dao.CategoriaDAO;
import it.ordinearticolocategoria.dao.EntityManagerUtil;
import it.ordinearticolocategoria.model.Categoria;
import it.ordinearticolocategoria.model.Ordine;

public class CategoriaServiceImpl implements CategoriaService{
	private CategoriaDAO categoriaDAO;
	@Override
	public List<Categoria> listAll() throws Exception {
		try {
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return categoriaDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Categoria caricaSingolaCategoria(Long id) throws Exception {
		try {
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return categoriaDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void aggiorna(Categoria categoriaInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			categoriaDAO.update(categoriaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void inserisciNuovo(Categoria categoriaInstance) throws Exception {
		// questo è come una connection
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// questo è come il MyConnection.getConnection()
			entityManager.getTransaction().begin();

			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			categoriaDAO.insert(categoriaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void rimuovi(Categoria categoriaInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			categoriaDAO.delete(categoriaInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public List<Categoria> findByExample(Categoria example) throws Exception {
		try {
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return categoriaDAO.findByExample(example);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;}
	}

	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO=categoriaDAO;
		
	}

	@Override
	public List<Categoria> TutteLeCategorieDiUnOrdine(Ordine ordineInput) throws Exception {
		try {
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return categoriaDAO.TutteLeCategorieDiUnOrdine(ordineInput);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
