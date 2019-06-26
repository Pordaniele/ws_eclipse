package it.prova.repository.ruolo;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;

import it.prova.model.Ingrediente;
import it.prova.model.Ruolo;

public interface RuoloRepository extends CrudRepository<Ruolo, Long>{
	List<Ruolo> findAll(Example<Ruolo> of);
}
