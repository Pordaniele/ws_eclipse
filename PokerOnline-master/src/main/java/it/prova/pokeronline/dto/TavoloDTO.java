package it.prova.pokeronline.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import it.prova.pokeronline.model.Tavolo;
import it.prova.pokeronline.model.Utente;

public class TavoloDTO {
	private Long id;
	private String denominazione;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataCreazione;
	private Integer esperienzaMin;
	private Double cifraMin;
	
	public TavoloDTO() {}

public TavoloDTO(Long id, String denominazione, Date dataCreazione, Integer esperienzaMin, Double cifraMin) {
	this.id=id;
	this.denominazione=denominazione;
	this.dataCreazione=dataCreazione;
	this.esperienzaMin=esperienzaMin;
	this.cifraMin=cifraMin;
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

public Date getDataCreazione() {
	return dataCreazione;
}

public void setDataCreazione(Date dataCreazione) {
	this.dataCreazione = dataCreazione;
}

public Integer getEsperienzaMin() {
	return esperienzaMin;
}

public void setEsperienzaMin(Integer esperienzaMin) {
	this.esperienzaMin = esperienzaMin;
}

public Double getCifraMin() {
	return cifraMin;
}

public void setCifraMin(Double cifraMin) {
	this.cifraMin = cifraMin;
}
	public static Tavolo buildTavoloInstanceForFindByExample(TavoloDTO input) {
		Tavolo example= new Tavolo();
		example.setDenominazione(StringUtils.isNotBlank(input.getDenominazione()) ? input.getDenominazione() : null);
		example.setCifraMin(input.getCifraMin());
		example.setEsperienzaMin(input.getEsperienzaMin());
		example.setDataCreazione(input.getDataCreazione());
		return example;
	}

	public static TavoloDTO buildDtoFromTavolo(Tavolo tavolo) {
		TavoloDTO temp= new TavoloDTO();
		temp.setCifraMin(tavolo.getCifraMin());
		temp.setDataCreazione(tavolo.getDataCreazione());
		temp.setDenominazione(tavolo.getDenominazione());
		temp.setId(tavolo.getId());
		temp.setEsperienzaMin(tavolo.getEsperienzaMin());
		return temp;
	}
	
	public static Tavolo buildTavoloFromDTO(TavoloDTO tavoloDTO) {
		Tavolo temp= new Tavolo();
		temp.setCifraMin(tavoloDTO.getCifraMin());
		temp.setDataCreazione(tavoloDTO.getDataCreazione());
		temp.setDenominazione(tavoloDTO.getDenominazione());
		temp.setId(tavoloDTO.getId());
		temp.setEsperienzaMin(tavoloDTO.getEsperienzaMin());
		return temp;
	}
}
