package it.prova.ebayjpa.service.acquisto;

import java.util.List;

import it.prova.ebayjpa.model.Acquisto;

public interface AcquistoService {
public List<Acquisto> list();
	
	public Acquisto get(long id);
	
	public void update(Acquisto o);
	
	public void insert(Acquisto o);
	
	public void delete(Acquisto o);
	
	public List<Acquisto> findByExample(Acquisto acquistoInstance);
}
