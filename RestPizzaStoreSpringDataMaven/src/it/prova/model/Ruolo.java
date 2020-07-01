package it.prova.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ruolo {
	public static final String ADMIN_ROLE = "ADMIN_ROLE";
	public static final String PIZZAIOLO_ROLE = "PIZZAIOLO_ROLE";
	public static final String FATTORINO_ROLE = "FATTORINO_ROLE";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private long id;
	private String descrizione;
	@Column(unique=true)
	private String codice;

	public Ruolo() {
	}

	public Ruolo(String descrizione, String codice) {
		this.descrizione = descrizione;
		this.codice = codice;
	}

public Ruolo (String codice) {
	this.codice=codice;
}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	@Override
	public String toString() {
		return "Ruolo [id=" + id + ", descrizione=" + descrizione + ", codice=" + codice + "]";
	}

	
	
}