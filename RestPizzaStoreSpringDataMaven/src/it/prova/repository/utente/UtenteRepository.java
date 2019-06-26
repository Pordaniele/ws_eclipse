package it.prova.repository.utente;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;

import it.prova.model.Utente;

public interface UtenteRepository extends CrudRepository<Utente, Long> {

	List<Utente> findAll(Example<Utente> of);
	
	Utente findByUsernameAndPassword(String username,String password);
}
