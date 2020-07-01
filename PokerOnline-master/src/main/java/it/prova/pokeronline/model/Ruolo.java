package it.prova.pokeronline.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ruolo {
		public static final String ADMIN_ROLE = "ADMIN_ROLE";
		public static final String USER_ROLE = "USER_ROLE";
		public static final String SPECIAL_USER_ROLE="SPECIAL_USER_ROLE";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descrizione;
	private String codice;
	
	public Ruolo() {}
	
	private Ruolo(String descrizione,String codice ) {
		this.descrizione = descrizione;
		this.codice=codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

}