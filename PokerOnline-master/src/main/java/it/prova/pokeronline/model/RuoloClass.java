//package it.prova.pokeronline.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class RuoloClass {
//
//	public static final String ADMIN_ROLE = "ADMIN_ROLE";
//	public static final String PLAYER_ROLE = "PLAYER_ROLE";
//	public static final String SPECIAL_PLAYER_ROLE = "SPECIAL_PLAYER_ROLE";
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//	private String descrizione;
//	private String codice;
//
//	public RuoloClass() {
//	}
//
//	public RuoloClass(String descrizione, String codice) {
//		this.descrizione = descrizione;
//		this.codice = codice;
//	}
//
//	public RuoloClass(String codice) {
//		this.codice = codice;
//	}
//
//	public RuoloClass(Long id) {
//		this.id = id;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getDescrizione() {
//		return descrizione;
//	}
//
//	public void setDescrizione(String descrizione) {
//		this.descrizione = descrizione;
//	}
//
//	public String getCodice() {
//		return codice;
//	}
//
//	public void setCodice(String codice) {
//		this.codice = codice;
//	}
//
//}
