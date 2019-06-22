package it.prova.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.model.Libro;

public interface LibroRepository extends CrudRepository<Libro, Long>,QueryByExampleExecutor <Libro> {

	
	@Query("from Libro a left join fetch a.autore where a.id = ?1")
	Libro caricaEager(Long id);
}
