package it.prova.pokeronline.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Utente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;

	@ManyToOne
	@JoinColumn(name = "statoUtenza_id", nullable = false)
	
	private StatoUtenza statoUtenza;
	@Temporal(TemporalType.DATE)
	private Date dataRegistrazione;
	private boolean inGioco;

	@ManyToMany
	@JoinTable(name = "utente_ruolo", joinColumns = @JoinColumn(name = "utente_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ruolo_id", referencedColumnName = "id"))
	
	private Set<Ruolo> ruoli = new HashSet<>(0);
	private Integer esperienzaAccumulata;
	private Double creditoAccumulato;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tavoloGiocato_id")
	private Tavolo tavoloGiocato;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "creatore")
	private Set<Tavolo> tavoliCreati;

	public Utente() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public StatoUtenza getStatoUtenza() {
		return statoUtenza;
	}

	public void setStatoUtenza(StatoUtenza statoUtenza) {
		this.statoUtenza = statoUtenza;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public boolean isInGioco() {
		return inGioco;
	}

	public void setInGioco(boolean inGioco) {
		this.inGioco = inGioco;
	}

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	public Integer getEsperienzaAccumulata() {
		return esperienzaAccumulata;
	}

	public void setEsperienzaAccumulata(Integer esperienzaAccumulata) {
		this.esperienzaAccumulata = esperienzaAccumulata;
	}

	public Double getCreditoAccumulato() {
		return creditoAccumulato;
	}

	public void setCreditoAccumulato(Double creditoAccumulato) {
		this.creditoAccumulato = creditoAccumulato;
	}

	public Tavolo getTavoloGiocato() {
		return tavoloGiocato;
	}

	public void setTavoloGiocato(Tavolo tavoloGiocato) {
		this.tavoloGiocato = tavoloGiocato;
	}

	public Set<Tavolo> getTavoliCreati() {
		return tavoliCreati;
	}

	public void setTavoliCreati(Set<Tavolo> tavoliCreati) {
		this.tavoliCreati = tavoliCreati;
	}

}
