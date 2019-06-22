package it.prova.pokeronline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatoUtenza {
	public static final String CREATO = "CREATO";
	public static final String ATTIVO = "ATTIVO";
	public static final String INATTIVO="INATTIVO";
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descrizione;
	private String codice;
	
	
	
	public StatoUtenza() {
		super();
	}

	private StatoUtenza(String descrizione, String codice) {
		this.descrizione = descrizione;
		this.codice=codice;
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

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}
	
}
