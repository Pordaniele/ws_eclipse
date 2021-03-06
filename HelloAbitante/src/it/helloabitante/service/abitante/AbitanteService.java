package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public interface AbitanteService {
	public void setAbitanteDAO(AbitanteDAO abitanteDAO);
	public List<Abitante> cercaPerNomeECognome(String nome, String cognome) throws Exception ;
	public List<Abitante> list() throws Exception;
	public Abitante findUserById(Long idInput) throws Exception;

	public int aggiornaAbitante(Abitante input) throws Exception;

	public int inserisciNuovoAbitante(Abitante input) throws Exception;

	public int rimuoviAbitante(Abitante input) throws Exception;

	public List<Abitante> findByExample(Abitante input) throws Exception;
	
	public Abitante get(Long id) throws Exception;

}
