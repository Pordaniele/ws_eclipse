package it.prova.pokeronline.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import it.prova.pokeronline.model.StatoUtenza;

public interface StatoUtenzaRepository extends CrudRepository<StatoUtenza, Long>, QueryByExampleExecutor<StatoUtenza>{
	
}
