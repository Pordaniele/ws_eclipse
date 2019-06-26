package it.prova.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import it.prova.model.Ruolo;



public class RuoloDTO {
	private long id;
	private String descrizione;
	private String codice;
	
	public RuoloDTO() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	
	public static RuoloDTO buildRuoloDTOFromModel(Ruolo ruolo) {
		RuoloDTO result= new RuoloDTO();
		result.setId(ruolo.getId());
		result.setDescrizione(ruolo.getDescrizione());
		result.setCodice(ruolo.getCodice());
		return result;
	}
	
	public static Ruolo buildRuoloModelFromDTO(RuoloDTO ruoloDTO) {
		Ruolo result = new Ruolo();
		result.setId(ruoloDTO.getId());
		result.setDescrizione(ruoloDTO.getDescrizione());
		result.setCodice(ruoloDTO.getCodice());
		return result;
	}

	public static Set<RuoloDTO> buildListFromModelList(Set<Ruolo> input) {
		Set<RuoloDTO> result = new HashSet<>();

		for (Ruolo ruoloItem : input) {
			// faccio il binding senza municipio tramite costruttore
			RuoloDTO ruoloDTOtemp = buildRuoloDTOFromModel(ruoloItem);
			
			result.add(ruoloDTOtemp);

		}

		return result;
	}
	
	public static Set<Ruolo> buildListFromDTO(Set<RuoloDTO> input) {
		Set<Ruolo> result = new HashSet<>();

		for (RuoloDTO ruoloItem : input) {
			// faccio il binding senza municipio tramite costruttore
			Ruolo ruolotemp = buildRuoloModelFromDTO(ruoloItem);

			result.add(ruolotemp);

		}

		return result;
	}
}
