package it.concessionariomoto.service.motociclo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.concessionariomoto.dao.motociclo.MotocicloDAO;
import it.concessionariomoto.model.Concessionario;
import it.concessionariomoto.model.Motociclo;

@Component
public class MotocicloServiceImpl implements MotocicloService {
	@Autowired
	private MotocicloDAO motocicloDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Motociclo> listAllMoto() {
		return motocicloDAO.list();
	}
	@Transactional(readOnly = true)
	@Override
	public Motociclo caricaSingoloMoto(Long id) {
		return motocicloDAO.get(id);
	}
	@Transactional
	@Override
	public void aggiorna(Motociclo motocicloInstance) {
		motocicloDAO.update(motocicloInstance);

	}
@Transactional
	@Override
	public void inserisciNuovo(Motociclo motocicloInstance) {
		motocicloDAO.insert(motocicloInstance);

	}
@Transactional
	@Override
	public void rimuovi(Motociclo motocicloInstance) {
		motocicloDAO.delete(motocicloInstance);
	}
@Transactional(readOnly = true)
	@Override
	public List<Motociclo> findByExample(Motociclo example) {
		return motocicloDAO.findByExample(example);
	}
@Transactional(readOnly = true)
	@Override
	public void refresh(Motociclo motocicloInstance) {
	motocicloDAO.refresh(motocicloInstance);

	}
@Override
public Long numeroMotoATorinoPrima2010() {
	return motocicloDAO.numeroMotoATorinoPrima2010();
}


}
