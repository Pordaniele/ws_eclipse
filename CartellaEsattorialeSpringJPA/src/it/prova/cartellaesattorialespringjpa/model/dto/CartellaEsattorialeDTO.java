package it.prova.cartellaesattorialespringjpa.model.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import it.prova.cartellaesattorialespringjpa.model.CartellaEsattoriale;

public class CartellaEsattorialeDTO {
	private Long id;
	private String denominazione;
	private int importo;
	private long idContribuente;
	
	public CartellaEsattorialeDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public CartellaEsattorialeDTO(String denominazione, int importo) {
		super();
		this.denominazione = denominazione;
		this.importo = importo;
	}
	public CartellaEsattorialeDTO(long id, String denominazione, int importo, long idContribuente) {
		super();
		this.id = id;
		this.denominazione = denominazione;
		this.importo = importo;
		this.idContribuente = idContribuente;
	}
	public CartellaEsattorialeDTO(String denominazione, int importo, long idContribuente) {
		super();
		this.denominazione = denominazione;
		this.importo = importo;
		this.idContribuente = idContribuente;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDenominazione() {
		return denominazione;
	}
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	public int getImporto() {
		return importo;
	}
	public void setImporto(int importo) {
		this.importo = importo;
	}
	public long getIdContribuente() {
		return idContribuente;
	}
	public void setIdContribuente(long idContribuente) {
		this.idContribuente = idContribuente;
	}
	
	public List<String> validate(){
		List <String> listaErrori = new ArrayList<String>();
	
		
		if (StringUtils.isEmpty( this.getDenominazione())) {
			listaErrori.add("Denominazione non valida");
		}
		if (importo<=0) {
			listaErrori.add("Importo non valido");}
		if (idContribuente<=0L) {
			listaErrori.add("Contribuente non valido");
		}
		
		return listaErrori;
		}

	public static CartellaEsattoriale buildCartellaFromDTO(CartellaEsattorialeDTO cartellaEsattorialeDTO) {
		CartellaEsattoriale cartellaEsattoriale=new CartellaEsattoriale();
		cartellaEsattoriale.setDenominazione(cartellaEsattorialeDTO.getDenominazione());
		cartellaEsattoriale.setImporto(cartellaEsattorialeDTO.getImporto());
		cartellaEsattoriale.setId(cartellaEsattorialeDTO.getId());
		
		return cartellaEsattoriale;
	}
	
	public static CartellaEsattorialeDTO buildDTOFromCartellaEsattoriale(CartellaEsattoriale cartellaEsattoriale) {
		CartellaEsattorialeDTO cartellaEsattorialeDTO=new CartellaEsattorialeDTO();
		cartellaEsattorialeDTO.setDenominazione(cartellaEsattoriale.getDenominazione());
		cartellaEsattorialeDTO.setImporto(cartellaEsattoriale.getImporto());
		cartellaEsattorialeDTO.setId(cartellaEsattoriale.getId());
		cartellaEsattorialeDTO.setIdContribuente(cartellaEsattoriale.getContribuente().getId());
		return cartellaEsattorialeDTO;
	}
}
