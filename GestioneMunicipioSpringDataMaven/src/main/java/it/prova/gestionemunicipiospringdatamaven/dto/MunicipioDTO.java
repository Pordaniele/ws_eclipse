package it.prova.gestionemunicipiospringdatamaven.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import it.prova.gestionemunicipiospringdatamaven.model.Abitante;
import it.prova.gestionemunicipiospringdatamaven.model.Municipio;

public class MunicipioDTO {
	private Long id;
	private String descrizione;
	private String codice;
	private String ubicazione;
	private Set<Abitante> abitanti = new HashSet<>();
	
	public MunicipioDTO() {}

	public MunicipioDTO(String descrizione, String codice, String ubicazione) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.ubicazione = ubicazione;
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

	public String getUbicazione() {
		return ubicazione;
	}

	public void setUbicazione(String ubicazione) {
		this.ubicazione = ubicazione;
	}

	public Set<Abitante> getAbitanti() {
		return abitanti;
	}

	public void setAbitanti(Set<Abitante> abitanti) {
		this.abitanti = abitanti;
	}
	
	public List<String> validate() {
		List<String> listaErrori = new ArrayList<String>();
		if (StringUtils.isEmpty(this.getDescrizione())) {
			listaErrori.add("descrizione non valido");
		}
		if (StringUtils.isEmpty(this.getCodice())) {
			listaErrori.add("codice non valido");
		}
		if (StringUtils.isEmpty(this.getUbicazione())) {
			listaErrori.add("ubicazione non valida");
		}
		return listaErrori;
}

	public static Municipio buildMunicipioFromDTO(MunicipioDTO municipioDTO) {
		Municipio temp= new Municipio();
		temp.setAbitanti(municipioDTO.getAbitanti());
		temp.setCodice(municipioDTO.getCodice());
		temp.setDescrizione(municipioDTO.getDescrizione());
		temp.setId(municipioDTO.getId());
		temp.setUbicazione(municipioDTO.getUbicazione());
		return temp;
	}
	
	public static MunicipioDTO buildDTOFromMunicipio(Municipio municipio) {
		MunicipioDTO temp= new MunicipioDTO();
		temp.setAbitanti(municipio.getAbitanti());
		temp.setCodice(municipio.getCodice());
		temp.setDescrizione(municipio.getDescrizione());
		temp.setId(municipio.getId());
		temp.setUbicazione(municipio.getUbicazione());
		return temp;
	}
	
}
