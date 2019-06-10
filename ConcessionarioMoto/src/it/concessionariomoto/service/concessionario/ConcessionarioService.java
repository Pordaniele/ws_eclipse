package it.concessionariomoto.service.concessionario;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.concessionariomoto.model.Concessionario;

public interface ConcessionarioService {
	public List<Concessionario> listAllMunicipi();

	public Concessionario caricaSingoloConcessionario(Long id);

	public Concessionario caricaSingoloConcessionarioEagerMoto(Long id);

	public void aggiorna(Concessionario concessionarioInstance);

	public void inserisciNuovo(Concessionario concessionarioInstance);

	public void rimuovi(Concessionario concessionarioInstance);

	public List<Concessionario> findByExample(Concessionario example);

	public void refresh(Concessionario concessionarioInstance);
	
	public List<Concessionario> listaOrdinataConcessionariMilanoCheHannoHondaImmatricolata20122016();
	public List<Concessionario> cercaConcessionariMoto1200Ordinati();
		
}
