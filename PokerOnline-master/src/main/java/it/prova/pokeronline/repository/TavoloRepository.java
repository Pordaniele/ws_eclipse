package it.prova.pokeronline.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;

public interface TavoloRepository extends CrudRepository<Tavolo, Long>, QueryByExampleExecutor<Tavolo>{
	
	List<Tavolo> findByCreatore(Utente creatore);

	
	@Query("from Tavolo t left join fetch t.giocatori where t.id= ?1")
	public Tavolo findGiocatori(Long id);

	
	public List<Tavolo> findByGiocatori(Set<Utente> utente);
//	
//	@Query("from Tavolo t left join fetch t.giocatori g where t.creatore.username like 1%? and g.username like 2%? and t.dataCreazione = 3?")
//	public List<Tavolo> findTavoliForCreatoreAndDataAndPartecipanti(String username, String username2, Date data);


}
