package it.prova.dao;

import java.util.ArrayList;
import java.util.List;

import it.prova.model.MateriaPrima;
import it.prova.model.StatoMateria;

public class DbMock {

	public static final List<MateriaPrima> MateriePrime = new ArrayList<MateriaPrima>();

	static {
		MateriaPrima mat_1 = new MateriaPrima(1, "Legno");
		MateriaPrima mat_2 = new MateriaPrima(2, "Acciaio");
		MateriaPrima mat_3 = new MateriaPrima(3, "Minerale");
		MateriePrime.add(mat_1);
		MateriePrime.add(mat_2);
		MateriePrime.add(mat_3);

	}

}
