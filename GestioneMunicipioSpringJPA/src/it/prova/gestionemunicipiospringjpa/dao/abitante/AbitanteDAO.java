package it.prova.gestionemunicipiospringjpa.dao.abitante;

import java.util.List;

import it.prova.gestionemunicipiospringjpa.dao.IBaseDAO;
import it.prova.gestionemunicipiospringjpa.model.Abitante;

public interface AbitanteDAO extends IBaseDAO<Abitante> {

	public Abitante getEager(long id);
}
