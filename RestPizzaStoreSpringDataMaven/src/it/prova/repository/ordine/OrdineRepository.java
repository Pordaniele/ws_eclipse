package it.prova.repository.ordine;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.model.Ingrediente;
import it.prova.model.Ordine;

public interface OrdineRepository extends CrudRepository<Ordine, Long> {
	List<Ordine> findAll(Example<Ordine> of);
	
	
	@Query("select o FROM Ordine o left join fetch o.pizze")
	List<Ordine> findALLEagerPizze();
	@Query("select o FROM Ordine o join fetch o.pizze p join fetch p.ingredienti where o.id =?1")
	Ordine cercaConPizza(Long id);
}
