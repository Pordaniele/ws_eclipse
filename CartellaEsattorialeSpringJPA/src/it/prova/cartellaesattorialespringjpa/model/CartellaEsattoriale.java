package it.prova.cartellaesattorialespringjpa.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartellaEsattoriale {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String denominazione;
	private int importo;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "contribuente_id", nullable = false)
	private Contribuente contribuente;

	public CartellaEsattoriale() {
	}

	public CartellaEsattoriale(String denominazione, int importo) {
		super();
		this.denominazione = denominazione;
		this.importo = importo;
	}

	public CartellaEsattoriale(Long id, String denominazione, int importo, Contribuente contribuente) {
		super();
		this.id = id;
		this.denominazione = denominazione;
		this.importo = importo;
		this.contribuente = contribuente;
	}

	public CartellaEsattoriale(Long id, String denominazione, int importo) {
		super();
		this.id = id;
		this.denominazione = denominazione;
		this.importo = importo;
	}

	public CartellaEsattoriale(String denominazione, int importo, Contribuente contribuente) {
		super();
		this.denominazione = denominazione;
		this.importo = importo;
		this.contribuente = contribuente;
	}

	public CartellaEsattoriale(String denominazione, Contribuente contribuente) {
		super();
		this.denominazione = denominazione;
		this.contribuente = contribuente;
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

	public Contribuente getContribuente() {
		return contribuente;
	}

	public void setContribuente(Contribuente contribuente) {
		this.contribuente = contribuente;
	}

}
