package it.prova.cartellaesattorialespringjpa.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import it.prova.cartellaesattorialespringjpa.model.Ruolo;
import it.prova.cartellaesattorialespringjpa.model.Utente;

public class UtenteDTO {
	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private Date dataRegistrazione;
	private Set<Ruolo> ruoli = new HashSet<>(0);

	public UtenteDTO() {
	}

	public UtenteDTO(String nome, String cognome, String username, String password, Date dataRegistrazione) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.dataRegistrazione = dataRegistrazione;
	}

	public UtenteDTO(String nome, String username, String password) {
		super();
		this.nome = nome;
		this.username = username;
		this.password = password;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
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

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
	}

	public List<String> validate() {
		List<String> listaErrori = new ArrayList<String>();
		if (StringUtils.isEmpty(this.getNome())) {
			listaErrori.add("Nome non valido");
		}
		if (StringUtils.isEmpty(this.getUsername())) {
			listaErrori.add("Username non valido");
		}
		if (StringUtils.isEmpty(this.getPassword())) {
			listaErrori.add("Password non valido");
		}
		if (StringUtils.isEmpty(this.getCognome())) {
			listaErrori.add("Cognome non valido");
		}

		return listaErrori;
	}

	public static Utente buildUtenteFromDTO(UtenteDTO utenteDTO) {
		Utente temp = new Utente();
		temp.setCognome(utenteDTO.getCognome());
		temp.setNome(utenteDTO.getNome());
		temp.setPassword(utenteDTO.getPassword());
		temp.setId(utenteDTO.getId());
		temp.setUsername(utenteDTO.getUsername());
		temp.setDataRegistrazione(utenteDTO.getDataRegistrazione());
		temp.setRuoli(utenteDTO.getRuoli());
		return temp;
	}
	public static UtenteDTO buildDTOFromUtente(Utente utente) {
		UtenteDTO temp = new UtenteDTO();
		temp.setCognome(utente.getCognome());
		temp.setNome(utente.getNome());
		temp.setPassword(utente.getPassword());
		temp.setId(utente.getId());
		temp.setUsername(utente.getUsername());
		temp.setDataRegistrazione(utente.getDataRegistrazione());
		temp.setRuoli(utente.getRuoli());
		return temp;
	}

}
