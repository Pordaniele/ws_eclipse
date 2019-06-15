package it.prova.ebayjpa.service.acquisto;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.ebayjpa.dao.acquisto.AcquistoDAO;
import it.prova.ebayjpa.dao.annuncio.AnnuncioDAO;
import it.prova.ebayjpa.dao.utente.UtenteDAO;
import it.prova.ebayjpa.model.Acquisto;
import it.prova.ebayjpa.model.Annuncio;
import it.prova.ebayjpa.model.Utente;
import it.prova.ebayjpa.service.annuncio.AnnuncioService;
import it.prova.ebayjpa.service.utente.UtenteService;

@Component
public class AcquistoServiceImpl implements AcquistoService {
	@Autowired
	private AcquistoDAO acquistoDAO;
	@Autowired
	private UtenteDAO utenteDAO;
	@Autowired
	private AnnuncioDAO annuncioDAO;
	@Autowired
	private UtenteService utenteService;
	@Autowired
	private AnnuncioService annuncioService;

	@Transactional(readOnly = true)
	@Override
	public List<Acquisto> list() {
		// TODO Auto-generated method stub
		return acquistoDAO.list();
	}

	@Transactional(readOnly = true)
	@Override
	public Acquisto get(long id) {
		return acquistoDAO.get(id);
	}

	@Transactional
	@Override
	public void update(Acquisto o) {
		acquistoDAO.update(o);
	}

	@Transactional
	@Override
	public void insert(Acquisto o) {
		acquistoDAO.insert(o);
	}

	@Transactional
	@Override
	public void delete(Acquisto o) {
		acquistoDAO.delete(o);

	}

	@Transactional(readOnly = true)
	@Override
	public List<Acquisto> findByExample(Acquisto acquistoInstance) {
		return acquistoDAO.findByExample(acquistoInstance);
	}

	@Transactional
	@Override
	public void compraVendita(long idUtenteCheCompra, long idAnnuncioDaComprare) {
		Utente utenteCheCompra = utenteService.caricaEagerAnnunci(idUtenteCheCompra);
		Annuncio annuncioDaComprare = annuncioService.caricaEager(idAnnuncioDaComprare);
		System.out.println(utenteCheCompra.getCognome());
		System.out.println(annuncioDaComprare.getTestoAnnuncio());
		if (utenteCheCompra.getCreditoResiduo() < annuncioDaComprare.getPrezzo())
			return;
		utenteCheCompra.setCreditoResiduo(utenteCheCompra.getCreditoResiduo() - annuncioDaComprare.getPrezzo());
		Calendar calendar =Calendar.getInstance();
		int anno=calendar.get(Calendar.YEAR);
		annuncioDaComprare.getUtente()
				.setCreditoResiduo(annuncioDaComprare.getPrezzo() + annuncioDaComprare.getUtente().getCreditoResiduo());
		Acquisto nuovoAcquisto = new Acquisto(annuncioDaComprare.getTestoAnnuncio(), anno,
				annuncioDaComprare.getPrezzo());
		nuovoAcquisto.setUtente(utenteCheCompra);
		if (annuncioDaComprare.isApertoChiuso() == false)
			return;
		annuncioDaComprare.setApertoChiuso(false);
		utenteCheCompra.getAcquisti().add(nuovoAcquisto);
		acquistoDAO.insert(nuovoAcquisto);
		utenteDAO.update(utenteCheCompra);
		annuncioDAO.update(annuncioDaComprare);
		return;
	}
}
