package it.prova.pokeronline.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
	private Set<UtenteDTO> giocatori = new HashSet<>(0);
	public TavoloDTO() {}

public TavoloDTO(Tavolo input) {
	this.id=input.getId();
	this.denominazione=input.getDenominazione();
	this.dataCreazione=input.getDataCreazione();
	this.esperienzaMin=input.getEsperienzaMin();
	this.cifraMin=input.getCifraMin();
	for (Utente item : input.getGiocatori()) {
		this.giocatori.add(new UtenteDTO(item));
	}
}

public Set<UtenteDTO> getGiocatori() {
	return giocatori;
}

public void setGiocatori(Set<UtenteDTO> giocatori) {
	this.giocatori = giocatori;
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
