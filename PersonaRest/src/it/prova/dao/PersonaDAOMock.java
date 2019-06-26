package it.prova.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import it.prova.model.Persona;

public class PersonaDAOMock {

	public static final List<Persona> DB_MOCK = new ArrayList<>();

	static {
		// preparo una lista mock perché ancora non ho il collegamento alla
		// base dati
		DB_MOCK.add(new Persona(1L, "Daniele", "Porcelli", 30));
		DB_MOCK.add(new Persona(2L, "Marco", "Frenchi", 30));
		DB_MOCK.add(new Persona(3L, "Paolo", "Villo", 50));
	}

	public Persona findById(Long idInput) {
		for (Persona personaItem : DB_MOCK) {
			if (personaItem.getId() == idInput) {
				return personaItem;
			}
		}

		return null;
	}

//	public List<Persona> findByEtaMaggioreDi(Integer eta) {
//		List<Persona> result = new ArrayList<>();
//		for (Persona personaItem : DB_MOCK) {
//			if (personaItem.getEta() >= eta) {
//				result.add(personaItem);
//			}
//		}
//
//		return result;
//	}
	public List<Persona> findByEtaMaggioreDi(Integer eta) {
		 List<Persona> result = DB_MOCK.stream().filter(item->item.getEta()>= eta).collect(Collectors.toList());
	return result;
	}
	
	public void insert(Persona personaInput) {
		Long maxId = 1L;
		for (Persona personaItem : DB_MOCK) {
			if (personaItem.getId() > maxId)
				maxId = personaItem.getId();
		}
		personaInput.setId(++maxId);
		DB_MOCK.add(personaInput);
	}

	public List<Persona> findAll() {
		return DB_MOCK;
	}

	public List<Persona> findByFields(String nome, String cognome) {
		List<Persona> result = new ArrayList<>();

		if ((nome == null || nome.isEmpty()) && (cognome == null || cognome.isEmpty()))
			return DB_MOCK;

		for (Persona personaItem : DB_MOCK) {
			if ((nome != null && !nome.isEmpty() && personaItem.getNome().startsWith(nome))
					|| (cognome != null && !cognome.isEmpty() && personaItem.getCognome().startsWith(cognome)))
				result.add(personaItem);
		}
		return result;
	}
	
	public boolean delete(Long idInput) {
		for (Persona personaItem : DB_MOCK) {
			if (personaItem.getId() == idInput) {
				DB_MOCK.remove(personaItem);
				return true;
			}
		}
		return false;
	}
	
	public Persona update(Persona input) {
		for (Persona personaItem : DB_MOCK) {
			if (personaItem.getId() == input.getId()) {
				personaItem.setNome(input.getNome());
				personaItem.setCognome(input.getCognome());
				personaItem.setEta(input.getEta());
				return personaItem;
			}
		}
		return null;
	}
	

}
