package it.prova.pokeronline.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import it.prova.pokeronline.model.Ruolo;
import it.prova.pokeronline.model.StatoUtenza;
import it.prova.pokeronline.model.Utente;

public class UtenteDTO {
	private Long id;
	private String nome;
	private String cognome;
	private String username;
	private String password;
	private StatoUtenza statoUtenza;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date dataRegistrazione;
	private Integer esperienzaAccumulata;
	private Double creditoAccumulato;
	private Set<Ruolo> ruoli = new HashSet<>(0);

	private TavoloDTO tavoloGiocato;
	
	public UtenteDTO(Utente input) {
		this.id=input.getId();
		this.nome=input.getNome();
		this.cognome=input.getCognome();
		this.username=input.getUsername();
		this.password=input.getPassword();
		this.statoUtenza=input.getStatoUtenza();
		this.dataRegistrazione=input.getDataRegistrazione();
		this.esperienzaAccumulata=input.getEsperienzaAccumulata();
		this.creditoAccumulato=input.getCreditoAccumulato();
		
		
	}
	public UtenteDTO() {}

	public Set<Ruolo> getRuoli() {
		return ruoli;
	}

	public void setRuoli(Set<Ruolo> ruoli) {
		this.ruoli = ruoli;
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

	public TavoloDTO getTavoloGiocato() {
		return tavoloGiocato;
	}

	public void setTavoloGiocato(TavoloDTO tavoloGiocato) {
		this.tavoloGiocato = tavoloGiocato;
	}
	
	public static Utente buildUtenteInstanceForFindByExample(UtenteDTO input) {
		Utente example= new Utente();
		example.setNome(StringUtils.isNotBlank(input.getNome()) ? input.getNome() : null);
		example.setCognome(StringUtils.isNotBlank(input.getCognome()) ? input.getCognome() : null);
		example.setUsername(StringUtils.isNotBlank(input.getUsername()) ? input.getUsername() : null);

		example.setEsperienzaAccumulata(input.getEsperienzaAccumulata());
		example.setCreditoAccumulato(input.getCreditoAccumulato());
		example.setDataRegistrazione(input.getDataRegistrazione());
		return example;
	}
	
	public static Utente buildUtenteFromDTO(UtenteDTO utenteDTO) {
		Utente temp=new Utente();
		temp.setCognome(utenteDTO.getCognome());
		temp.setCreditoAccumulato(utenteDTO.getCreditoAccumulato());
		temp.setDataRegistrazione(utenteDTO.getDataRegistrazione());
		temp.setEsperienzaAccumulata(utenteDTO.getEsperienzaAccumulata());
		temp.setId(utenteDTO.getId());
		temp.setNome(utenteDTO.getNome());
		temp.setPassword(utenteDTO.getPassword());
		temp.setStatoUtenza(utenteDTO.getStatoUtenza());
		temp.setRuoli(utenteDTO.getRuoli());
		
		temp.setUsername(utenteDTO.getUsername());
		return temp;
	}
	
}
