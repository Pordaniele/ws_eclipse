package it.prova.ebayjpa.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import it.prova.ebayjpa.model.Acquisto;
import it.prova.ebayjpa.model.Utente;

public class AcquistoDTO {
	private Long id;
	private String descrizione;
	private Integer anno;
	private double prezzo;
	private Utente utente;

	public AcquistoDTO(String descrizione, Integer anno, double prezzo) {
		super();
		this.descrizione = descrizione;
		this.anno = anno;
		this.prezzo = prezzo;
	}

	public AcquistoDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Integer getAnno() {
		return anno;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public List<String> validate() {
		List<String> listaErrori = new ArrayList<String>();
		if (StringUtils.isEmpty(this.getDescrizione())) {
			listaErrori.add("descrizione non valido");
		}
		if(this.getPrezzo()<0) {
			listaErrori.add("Prezzo non valido");
		}
		return listaErrori;
}
	public Acquisto buildAcquistoFromDTO(AcquistoDTO acquistoDTO) {
		Acquisto temp= new Acquisto();
		temp.setAnno(acquistoDTO.getAnno());
		temp.setDescrizione(acquistoDTO.getDescrizione());
		temp.setId(acquistoDTO.getId());
		temp.setPrezzo(acquistoDTO.getPrezzo());
		temp.setUtente(acquistoDTO.getUtente() );
		return temp;
	}
	
	public AcquistoDTO buildDTOFromAcquisto(Acquisto acquisto) {
		AcquistoDTO temp= new AcquistoDTO();
		temp.setAnno(acquisto.getAnno());
		temp.setDescrizione(acquisto.getDescrizione());
		temp.setId(acquisto.getId());
		temp.setPrezzo(acquisto.getPrezzo());
		temp.setUtente(acquisto.getUtente() );
		return temp;
	}
}
