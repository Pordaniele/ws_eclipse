package it.prova.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import it.prova.model.Cliente;
import it.prova.model.Ordine;

public class ClienteDTO {
	private Long id;
	private String nome;
	private String cognome;
	private String via;
	private String citta;
	private String telefono;
	private boolean attivo;
	@JsonIgnoreProperties(value = { "cliente" })
	Set<OrdineDTO> ordini = new HashSet<>(0);
	
	
	
	public ClienteDTO() {
		super();
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
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCitta() {
		return citta;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public boolean isAttivo() {
		return attivo;
	}
	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}
	public Set<OrdineDTO> getOrdini() {
		return ordini;
	}
	public void setOrdini(Set<OrdineDTO> ordini) {
		this.ordini = ordini;
	}
	
	public static ClienteDTO buildClienteDTOFromModel(Cliente input, boolean includeOrdine, boolean includeIngredienti, boolean includePizze) {
		ClienteDTO result= new ClienteDTO();
		result.setAttivo(input.isAttivo());
		result.setCitta(input.getCitta());
		result.setCognome(input.getCognome());
		result.setId(input.getId());
		result.setNome(input.getNome());
		result.setTelefono(input.getTelefono());
		result.setVia(input.getVia());
		if(includeOrdine) {
			for(Ordine ordineItem: input.getOrdini()) {
				result.getOrdini().add(OrdineDTO.buildOrdineDTOFromModel(ordineItem, includePizze, includeIngredienti));
			}
		}
		return result;
	}
	
	public static Cliente buildClienteFromDTO(ClienteDTO input, boolean includeOrdine, boolean includeIngredienti, boolean includePizze) {
		Cliente result= new Cliente();
		result.setAttivo(input.isAttivo());
		result.setCitta(input.getCitta());
		result.setCognome(input.getCognome());
		result.setId(input.getId());
		result.setNome(input.getNome());
		result.setTelefono(input.getTelefono());
		result.setVia(input.getVia());
		if(includeOrdine) {
			for(OrdineDTO ordineItem: input.getOrdini()) {
				result.getOrdini().add(OrdineDTO.buildOrdineFromDTO(ordineItem, includePizze, includeIngredienti));
			}
		}
		return result;
	}
	
}
