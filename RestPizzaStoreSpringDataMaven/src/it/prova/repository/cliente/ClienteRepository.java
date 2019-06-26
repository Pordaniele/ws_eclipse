package it.prova.repository.cliente;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.model.Cliente;
import it.prova.model.Ingrediente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	List<Cliente> findAll(Example<Cliente> of);

	
	@Query("select c FROM Cliente c left join fetch c.ordini")
	List<Cliente> findAllEagerOrdini();
	@Query("select c from Cliente c left join fetch c.ordini where c.id =?1")
	Cliente caricaEager (Long id);
}
