package it.prova.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.prova.dao.DbMock;
import it.prova.dao.MateriaPrimaDAO;
import it.prova.model.MateriaPrima;

@Component
public class MateriaPrimaServiceImpl implements MateriaPrimaService {

	@Autowired
	private MateriaPrimaDAO materiaPrimaDAO;
	@Autowired
	private LavorazioneService lavorazioneService;
	@Autowired
	private AssemblaggioService assemblaggioService;
	@Autowired
	private VerniciaturaService verniciaturaService;
	@Autowired
	private MessaInOperaService messaInoperaService;

	@Override
	public void iniziaLavorazione() {

		System.out.println("*######################################");
		for (MateriaPrima materiaItem : DbMock.MateriePrime) {
			System.out.println("Inizio Lavorazione " + materiaItem.getDescrizione());
			System.out.println("stato lavoro: "+materiaItem.getStato());
			lavorazioneService.inLavorazione(materiaItem);
			assemblaggioService.inAssemblaggio(materiaItem);
			verniciaturaService.inVerniciatura(materiaItem);
			messaInoperaService.messaInOpera(materiaItem);
			System.out.println();
		}
		System.out.println("######################################");
		System.out.println("Termine lavorazione!");

	}

	@Override
	public MateriaPrima cercaPerId(int id) {
		return materiaPrimaDAO.cercaPerId(id);
	}

	@Override
	public void aggiungiMateriaPrima(MateriaPrima materiaPrima) {
		materiaPrimaDAO.aggiungiMateriaPrima(materiaPrima);

	}

}
