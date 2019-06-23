package it.prova.pokeronline.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.pokeronline.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long>, QueryByExampleExecutor<Utente>{
	
	Utente findByUsernameAndPassword(String username, String password);
	@Query("select u FROM Utente u left join fetch u.ruoli  where u.id= ?1")
	Utente caricaUtentePerUsernamePasswordeRuolo(Long id);
	
	Utente findByUsername (String username);
}
