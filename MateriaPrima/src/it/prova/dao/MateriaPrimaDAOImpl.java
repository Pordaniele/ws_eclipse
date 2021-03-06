package it.prova.dao;

import org.springframework.stereotype.Component;

import it.prova.model.MateriaPrima;

@Component
public class MateriaPrimaDAOImpl implements MateriaPrimaDAO {

	@Override
	public MateriaPrima cercaPerId(int id) {

		for (MateriaPrima materiaItem : DbMock.MateriePrime) {
			if (materiaItem.getId() == id)
				return materiaItem;
		}
		return null;
	}

	@Override
	public void aggiungiMateriaPrima(MateriaPrima materiaPrima) {
		DbMock.MateriePrime.add(materiaPrima);

	}

}
