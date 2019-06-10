package it.prova.service;

import it.prova.model.MateriaPrima;

public interface MateriaPrimaService {

	public MateriaPrima cercaPerId(int id);

	public void iniziaLavorazione();
	public void aggiungiMateriaPrima(MateriaPrima materiaPrima);
}
