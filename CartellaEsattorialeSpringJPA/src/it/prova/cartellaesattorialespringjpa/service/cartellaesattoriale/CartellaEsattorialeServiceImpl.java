package it.prova.cartellaesattorialespringjpa.service.cartellaesattoriale;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.prova.cartellaesattorialespringjpa.dao.cartellaesattoriale.CartellaEsattorialeDAO;
import it.prova.cartellaesattorialespringjpa.model.CartellaEsattoriale;

@Component
public class CartellaEsattorialeServiceImpl implements CartellaEsattorialeService {

	@Autowired
	private CartellaEsattorialeDAO cartellaEsattorialeDAO;

	@Transactional(readOnly = true)
	@Override
	public List<CartellaEsattoriale> listAll() {
		return cartellaEsattorialeDAO.list();
	}

	@Transactional(readOnly = true)
	@Override
	public CartellaEsattoriale caricaSingolaCartella(Long id) {
		return cartellaEsattorialeDAO.get(id);
	}

	@Transactional
	@Override
	public void aggiorna(CartellaEsattoriale cartellaInstance) {
		cartellaEsattorialeDAO.update(cartellaInstance);
	}

	@Transactional
	@Override
	public void inserisciNuovo(CartellaEsattoriale cartellaInstance) {
		cartellaEsattorialeDAO.insert(cartellaInstance);
	}

	@Transactional
	@Override
	public void rimuovi(CartellaEsattoriale cartellaInstance) {
		cartellaEsattorialeDAO.delete(cartellaInstance);
	}

	@Transactional(readOnly = true)
	@Override
	public List<CartellaEsattoriale> findByExample(CartellaEsattoriale example) {
		return cartellaEsattorialeDAO.findByExample(example);
	}

}
