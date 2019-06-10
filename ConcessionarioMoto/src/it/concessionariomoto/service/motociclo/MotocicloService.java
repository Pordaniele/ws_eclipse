package it.concessionariomoto.service.motociclo;

import java.util.List;

import it.concessionariomoto.model.Concessionario;
import it.concessionariomoto.model.Motociclo;

public interface MotocicloService {
	public List<Motociclo> listAllMoto();

	public Motociclo caricaSingoloMoto(Long id);

	public void aggiorna(Motociclo motocicloInstance);

	public void inserisciNuovo(Motociclo motocicloInstance);

	public void rimuovi(Motociclo motocicloInstance);

	public List<Motociclo> findByExample(Motociclo example);
	
	public void refresh(Motociclo motocicloInstance);
	
	public Long numeroMotoATorinoPrima2010();
 
	
}
