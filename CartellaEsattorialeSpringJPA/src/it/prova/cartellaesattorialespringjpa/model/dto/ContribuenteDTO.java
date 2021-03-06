package it.prova.cartellaesattorialespringjpa.model.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import it.prova.cartellaesattorialespringjpa.model.CartellaEsattoriale;
import it.prova.cartellaesattorialespringjpa.model.Contribuente;

public class ContribuenteDTO {
	private Long id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private String indirizzo;
	private Set<CartellaEsattoriale> cartelle = new HashSet<>();
	
	
	public ContribuenteDTO(String nome, String cognome, String codiceFiscale, String indirizzo) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.indirizzo = indirizzo;
	}

	public ContribuenteDTO() {}
	
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
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public Set<CartellaEsattoriale> getCartelle() {
		return cartelle;
	}
	public void setCartelle(Set<CartellaEsattoriale> cartelle) {
		this.cartelle = cartelle;
	}
	
	public List<String> validate(){
		List <String> listaErrori = new ArrayList<String>();
		if (StringUtils.isEmpty( this.getNome())) {
			listaErrori.add("Nome non valido");
		}
		if (StringUtils.isEmpty( this.getCognome())) {
			listaErrori.add("Cognome non valido");
		}
		if (StringUtils.isEmpty( this.getCodiceFiscale())) {
			listaErrori.add("Codice fiscale non valido");
		}
		if(StringUtils.isEmpty( this.getIndirizzo())) {
			listaErrori.add("Indirizzo non valido");
		}
		return listaErrori;
	}

	public static Contribuente buildContribuenteFromDTO(ContribuenteDTO contribuenteDTO) {
		Contribuente contribuente= new Contribuente();
		contribuente.setNome(contribuenteDTO.getNome());
		contribuente.setCognome(contribuenteDTO.getCognome());
		contribuente.setIndirizzo(contribuenteDTO.getIndirizzo());
		contribuente.setCodiceFiscale(contribuenteDTO.getCodiceFiscale());
		contribuente.setId(contribuenteDTO.getId());
		return contribuente;
		
	}
	public static ContribuenteDTO buildContribuenteDTOFromContribuente(Contribuente contribuente){
		ContribuenteDTO contribuenteDTO= new ContribuenteDTO();
		contribuenteDTO.setNome(contribuente.getNome());
		contribuenteDTO.setCognome(contribuente.getCognome());
		contribuenteDTO.setCodiceFiscale(contribuente.getCodiceFiscale());
		contribuenteDTO.setIndirizzo(contribuente.getIndirizzo());
		contribuenteDTO.setId(contribuente.getId());
		return contribuenteDTO;
	}
	
}
