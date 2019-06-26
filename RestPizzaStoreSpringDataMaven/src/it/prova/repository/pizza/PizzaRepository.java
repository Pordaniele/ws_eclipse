package it.prova.repository.pizza;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.model.Ingrediente;
import it.prova.model.Pizza;

public interface PizzaRepository extends CrudRepository<Pizza, Long>{
	List<Pizza> findAll(Example<Pizza> of);
	
	@Query("select p FROM Pizza p left join fetch p.ingredienti left join fetch p.ordini")
	List<Pizza> findAllEagerIngredientiAndOrdini();
}
