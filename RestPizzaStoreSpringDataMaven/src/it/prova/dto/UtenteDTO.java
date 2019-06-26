package it.prova.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import it.prova.model.Utente;

public class UtenteDTO {

	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataRegistrazione;
	private String stato;
	private Set<RuoloDTO> ruoli = new HashSet<>(0);

	public UtenteDTO() {
	}

	public UtenteDTO(String nome, String cognome, String username, String password, Date dataRegistrazione,
			String stato) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataRegistrazione = dataRegistrazione;
		this.stato = stato;
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

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public Set<RuoloDTO> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<RuoloDTO> ruoli) {
		this.ruoli = ruoli;
	}

	public static UtenteDTO buildUtenteDTOFromModel(Utente utente) {
		UtenteDTO result = new UtenteDTO();
		result.setId(utente.getId());
		result.setCognome(utente.getCognome());
		result.setDataRegistrazione(utente.getDataRegistrazione());
		result.setNome(utente.getNome());
		result.setPassword(utente.getPassword());
		result.setStato(utente.getStato());
		result.setUsername(utente.getUsername());
		result.setRuoli(RuoloDTO.buildListFromModelList(utente.getRuoli()));
		return result;
	}

	public static Utente buildUtenteFromUtenteDTO(UtenteDTO utente) {
		Utente result = new Utente();
		result.setId(utente.getId());
		result.setCognome(utente.getCognome());
		result.setDataRegistrazione(utente.getDataRegistrazione());
		result.setNome(utente.getNome());
		result.setPassword(utente.getPassword());
		result.setStato(utente.getStato());
		result.setUsername(utente.getUsername());
		result.setRuoli(RuoloDTO.buildListFromDTO(utente.getRuoli()));
		return result;
	}

	public static List<UtenteDTO> buildListFromModelList(List<Utente> input) {
		List<UtenteDTO> result = new ArrayList<>();
		for (Utente utenteItem : input) {
			// faccio il binding senza ruoli tramite costruttore
			UtenteDTO utenteDTOtemp = buildUtenteDTOFromModel(utenteItem);

			utenteDTOtemp.setRuoli(RuoloDTO.buildListFromModelList(utenteItem.getRuoli()));

			result.add(utenteDTOtemp);
		}
		return result;
	}

	public static List<Utente> buildListFromDTOList(List<UtenteDTO> input) {
		List<Utente> result = new ArrayList<>();
		for (UtenteDTO utenteItem : input) {
			// faccio il binding senza municipio tramite costruttore
			Utente utentetemp = buildUtenteFromUtenteDTO(utenteItem);
			// costruisco un municipio senza portarmi dietro gli abitanti con 'false' nei
			// parametri
			utentetemp.setRuoli(RuoloDTO.buildListFromDTO(utenteItem.getRuoli()));
			result.add(utentetemp);
		}
		return result;
	}

}
