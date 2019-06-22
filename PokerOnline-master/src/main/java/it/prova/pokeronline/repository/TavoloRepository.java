package it.prova.pokeronline.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;

public interface TavoloRepository extends CrudRepository<Tavolo, Long>, QueryByExampleExecutor<Tavolo>{
	
	List<Tavolo> findByCreatore(Utente creatore);

	
	@Query("from Tavolo t left join fetch t.giocatori where t.id= ?1")
	public Tavolo findGiocatori(Long id);

}
