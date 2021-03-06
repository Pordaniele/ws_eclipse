package it.ordinearticolocategoria.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.ordinearticolocategoria.dao.EntityManagerUtil;
import it.ordinearticolocategoria.dao.OrdineDAO;
import it.ordinearticolocategoria.model.Categoria;
import it.ordinearticolocategoria.model.Ordine;

public class OrdineServiceImpl implements OrdineService{

	private OrdineDAO ordineDAO;
	@Override
	public List<Ordine> listAll() throws Exception {
		try {
			// uso l'injection per il dao
			ordineDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return ordineDAO.list();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public Ordine caricaSingoloOrdine(Long id) throws Exception {
		try {
			// uso l'injection per il dao
			ordineDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return ordineDAO.get(id);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void aggiorna(Ordine ordineInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			ordineDAO.update(ordineInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}

	@Override
	public void inserisciNuovo(Ordine ordineInstance) throws Exception {
		// questo è come una connection
				EntityManager entityManager = EntityManagerUtil.getEntityManager();

				try {
					// questo è come il MyConnection.getConnection()
					entityManager.getTransaction().begin();

					// uso l'injection per il dao
					ordineDAO.setEntityManager(entityManager);

					// eseguo quello che realmente devo fare
					ordineDAO.insert(ordineInstance);

					entityManager.getTransaction().commit();
				} catch (Exception e) {
					entityManager.getTransaction().rollback();
					e.printStackTrace();
					throw e;
				}
	}

	@Override
	public void rimuovi(Ordine ordineInstance) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();
		try {
			entityManager.getTransaction().begin();
			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			ordineDAO.delete(ordineInstance);

			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public List<Ordine> findByExample(Ordine example) throws Exception {
		try {
			// uso l'injection per il dao
			ordineDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return ordineDAO.findByExample(example);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;}
	}

	@Override
	public void setOrdineDAO(OrdineDAO ordineDAO) {
	this.ordineDAO=ordineDAO;
		
	}

	@Override
	public List<Ordine> ordineEffetturatiPerCategoria(Categoria categoria) throws Exception {
		try {
			// uso l'injection per il dao
			ordineDAO.setEntityManager(EntityManagerUtil.getEntityManager());

			// eseguo quello che realmente devo fare
			return ordineDAO.ordineEffetturatiPerCategoria(categoria);

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
