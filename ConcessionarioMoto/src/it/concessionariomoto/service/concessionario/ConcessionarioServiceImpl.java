package it.concessionariomoto.service.concessionario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.concessionariomoto.dao.concessionario.ConcessionarioDAO;
import it.concessionariomoto.model.Concessionario;

@Component
public class ConcessionarioServiceImpl implements ConcessionarioService {
	@Autowired
	private ConcessionarioDAO concessionarioDAO;

	@Transactional(readOnly = true)
	@Override
	public List<Concessionario> listAllMunicipi() {
		return concessionarioDAO.list();
	}

	@Transactional(readOnly = true)
	@Override
	public Concessionario caricaSingoloConcessionario(Long id) {
		return concessionarioDAO.get(id);
	}

	@Transactional
	@Override
	public void aggiorna(Concessionario concessionarioInstance) {
		concessionarioDAO.update(concessionarioInstance);
	}

	@Transactional
	@Override
	public void inserisciNuovo(Concessionario concessionarioInstance) {
		concessionarioDAO.insert(concessionarioInstance);
	}

	@Transactional
	@Override
	public void rimuovi(Concessionario concessionarioInstance) {
		concessionarioDAO.delete(concessionarioInstance);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Concessionario> findByExample(Concessionario example) {
		return concessionarioDAO.findByExample(example);
	}

	@Transactional(readOnly = true)
	@Override
	public void refresh(Concessionario concessionarioInstance) {
		concessionarioDAO.refresh(concessionarioInstance);
	}

	@Override
	public Concessionario caricaSingoloConcessionarioEagerMoto(Long id) {
		return concessionarioDAO.findEagerFetch(id);
	
	}

	@Override
	public List<Concessionario> cercaConcessionariMoto1200Ordinati() {
		return concessionarioDAO.cercaConcessionariMoto1200Ordinati();
	}

	@Override
	public List<Concessionario> listaOrdinataConcessionariMilanoCheHannoHondaImmatricolata20122016() {
		return concessionarioDAO.listaOrdinataConcessionariMilanoCheHannoHondaImmatricolata20122016();
	}

}
