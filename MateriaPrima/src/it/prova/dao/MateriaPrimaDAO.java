package it.prova.dao;

import it.prova.model.MateriaPrima;

public interface MateriaPrimaDAO {

	public MateriaPrima cercaPerId(int id);

	public void aggiungiMateriaPrima(MateriaPrima materiaPrima);
}
