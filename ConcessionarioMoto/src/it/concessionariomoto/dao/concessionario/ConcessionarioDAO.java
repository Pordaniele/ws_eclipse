package it.concessionariomoto.dao.concessionario;

import java.util.List;

import it.concessionariomoto.daoz.IBaseDAO;
import it.concessionariomoto.model.Concessionario;

public interface ConcessionarioDAO extends IBaseDAO<Concessionario> {
	public Concessionario findEagerFetch(long id);

	public List<Concessionario> cercaConcessionariMoto1200Ordinati();

	public List<Concessionario> listaOrdinataConcessionariMilanoCheHannoHondaImmatricolata20122016();
}
