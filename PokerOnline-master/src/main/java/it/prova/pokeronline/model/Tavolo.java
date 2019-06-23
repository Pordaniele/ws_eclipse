package it.prova.pokeronline.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tavolo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String denominazione;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "utenteCreatore_id", nullable = false)
	private Utente creatore;
	@Temporal(TemporalType.DATE)
	private Date dataCreazione;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tavoloGiocato", orphanRemoval = false)
	private Set<Utente> giocatori = new HashSet<>(0);
	private Integer esperienzaMin;
	private Double cifraMin;

	public Tavolo(Long id, Utente creatore, Date dataCreazione, Set<Utente> giocatori, Integer esperienzaMin,
			Double cifraMin) {
		super();
		this.id = id;
		this.creatore = creatore;
		this.dataCreazione = dataCreazione;
		this.giocatori = giocatori;
		this.esperienzaMin = esperienzaMin;
		this.cifraMin = cifraMin;
	}

	public Tavolo() {}
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

	public Utente getCreatore() {
		return creatore;
	}

	public void setCreatore(Utente creatore) {
		this.creatore = creatore;
	}

	public Date getDataCreazione() {
		return dataCreazione;
	}

	public void setDataCreazione(Date dataCreazione) {
		this.dataCreazione = dataCreazione;
	}

	public Set<Utente> getGiocatori() {
		return giocatori;
	}

	public void setGiocatori(Set<Utente> giocatori) {
		this.giocatori = giocatori;
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

}
