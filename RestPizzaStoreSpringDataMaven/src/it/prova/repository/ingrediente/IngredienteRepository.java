package it.prova.repository.ingrediente;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.model.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {

	List<Ingrediente> findAll(Example<Ingrediente> of);
	
	@Query("select i FROM Ingrediente i left join fetch i.pizze")
	List<Ingrediente> findAllEagerPizze();
	
}
