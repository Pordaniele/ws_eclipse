package it.prova.dao;

import java.util.ArrayList;
import java.util.List;

import it.prova.model.Persona;

public class AutomobileDAOMock {

	public static final List<Persona> DB_MOCK = new ArrayList<>();

	static {
		// preparo una lista mock perché ancora non ho il collegamento alla
		// base dati
		DB_MOCK.add(new Persona(1L, "fiat", "panda"));
		DB_MOCK.add(new Persona(2L, "opel", "corsa"));
		DB_MOCK.add(new Persona(3L, "audi", "A1"));
	}

	public Persona findById(Long idInput) {
		for (Persona automobileItem : DB_MOCK) {
			if (automobileItem.getId() == idInput) {
				return automobileItem;
			}
		}

		return null;
	}

	public void insert(Persona automobileInput) {
		Long maxId = 1L;
		for (Persona automobileItem : DB_MOCK) {
			if (automobileItem.getId() > maxId)
				maxId = automobileItem.getId();
		}
		automobileInput.setId(++maxId);
		DB_MOCK.add(automobileInput);
	}

	public List<Persona> findAll() {
		return DB_MOCK;
	}

	public List<Persona> findByFields(String marca, String modello) {
		List<Persona> result = new ArrayList<>();

		if ((marca == null || marca.isEmpty()) && (modello == null || modello.isEmpty()))
			return DB_MOCK;

		for (Persona automobileItem : DB_MOCK) {
			if ((marca != null && !marca.isEmpty() && automobileItem.getMarca().startsWith(marca))
					|| (modello != null && !modello.isEmpty() && automobileItem.getModello().startsWith(modello)))
				result.add(automobileItem);
		}
		return result;
	}
	
	public boolean delete(Long idInput) {
		for (Persona automobileItem : DB_MOCK) {
			if (automobileItem.getId() == idInput) {
				DB_MOCK.remove(automobileItem);
				return true;
			}
		}
		return false;
	}
	
	public Persona update(Persona input) {
		for (Persona automobileItem : DB_MOCK) {
			if (automobileItem.getId() == input.getId()) {
				automobileItem.setMarca(input.getMarca());
				automobileItem.setModello(input.getModello());
				return automobileItem;
			}
		}
		return null;
	}

}
