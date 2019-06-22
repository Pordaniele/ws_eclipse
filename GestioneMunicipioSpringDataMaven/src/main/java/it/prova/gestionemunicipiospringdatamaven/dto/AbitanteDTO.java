package it.prova.gestionemunicipiospringdatamaven.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import it.prova.gestionemunicipiospringdatamaven.model.Abitante;

public class AbitanteDTO {
	private Long id;
	private String nome;
	private String cognome;
	private Integer eta;
	private String residenza;
	private Long municipioId;
	
	public AbitanteDTO(String nome, String cognome, Integer eta, String residenza, Long municipioId) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.residenza = residenza;
		this.municipioId = municipioId;
	}
	
	public AbitanteDTO() {}

	public AbitanteDTO(String nome, String cognome, Integer eta, String residenza) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.residenza = residenza;
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

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	public String getResidenza() {
		return residenza;
	}

	public void setResidenza(String residenza) {
		this.residenza = residenza;
	}

	public Long getMunicipioId() {
		return municipioId;
	}

	public void setMunicipio(Long municipioId) {
		this.municipioId = municipioId;
	}
	
	public List<String> validate() {
		List<String> listaErrori = new ArrayList<String>();
		if (StringUtils.isEmpty(this.getCognome())) {
			listaErrori.add("cognome non valido");
		}
		if (StringUtils.isEmpty(this.getNome())) {
			listaErrori.add("nome non valido");
		}
		if (StringUtils.isEmpty(this.getResidenza())) {
			listaErrori.add("residenza non valida");
		}
		if(eta==null||eta<0) {
			listaErrori.add("eta non valida");
		}
		if(municipioId==null||municipioId<0) {
			listaErrori.add("Inserire un municipio valido");
		}
		
		return listaErrori;
	}
	public static Abitante buildAbitanteFromDTO(AbitanteDTO abitanteDTO) {
		Abitante temp= new Abitante();
		temp.setCognome(abitanteDTO.getCognome());
		temp.setEta(abitanteDTO.getEta());
		temp.setId(abitanteDTO.getId());
		
		temp.setNome(abitanteDTO.getNome());
		temp.setResidenza(abitanteDTO.getResidenza());
		return temp;
	}
	public static AbitanteDTO buildDTOFromAbitante(Abitante abitante) {
		AbitanteDTO temp= new AbitanteDTO();
		temp.setCognome(abitante.getCognome());
		temp.setEta(abitante.getEta());
		temp.setId(abitante.getId());
		
		temp.setNome(abitante.getNome());
		temp.setResidenza(abitante.getResidenza());
		return temp;
	}
	
}
