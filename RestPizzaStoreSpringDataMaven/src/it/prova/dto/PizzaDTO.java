package it.prova.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import it.prova.model.Ingrediente;
import it.prova.model.Ordine;
import it.prova.model.Pizza;

public class PizzaDTO {
	private Long id;
	private String descrizione;
	private String codice;
	private Double prezzoBase;
	private boolean attivo;
	@JsonIgnoreProperties(value = { "pizze" })
	Set<IngredienteDTO> ingredienti = new HashSet<>(0);
	@JsonIgnoreProperties(value = { "pizze" })
	Set<OrdineDTO> ordini = new HashSet<>(0);

	public PizzaDTO(String descrizione, String codice, Double prezzoBase, boolean attivo,
			Set<IngredienteDTO> ingredienti, Set<OrdineDTO> ordini) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.prezzoBase = prezzoBase;
		this.attivo = attivo;
		this.ingredienti = ingredienti;
		this.ordini = ordini;
	}

	public PizzaDTO() {
		super();
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

	public Double getPrezzoBase() {
		return prezzoBase;
	}

	public void setPrezzoBase(Double prezzoBase) {
		this.prezzoBase = prezzoBase;
	}

	public boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	public Set<IngredienteDTO> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(Set<IngredienteDTO> ingredienti) {
		this.ingredienti = ingredienti;
	}

	public Set<OrdineDTO> getOrdini() {
		return ordini;
	}

	public void setOrdini(Set<OrdineDTO> ordini) {
		this.ordini = ordini;
	}

	public static PizzaDTO buildPizzaDTOFromModel(Pizza input, boolean includeOdrini, boolean includeIngredienti) {
		PizzaDTO result = new PizzaDTO();
		result.setId(input.getId());
		result.setAttivo(input.isAttivo());
		result.setDescrizione(input.getDescrizione());
		result.setPrezzoBase(input.getPrezzoBase());
		result.setCodice(input.getCodice());
		if (includeOdrini) {
			for (Ordine ordineitem : input.getOrdini()) {
				result.getOrdini().add(OrdineDTO.buildOrdineDTOFromModel(ordineitem, false,false));
			}
		}
		if (includeIngredienti) {
			for (Ingrediente ingredienteItem : input.getIngredienti()) {
				result.getIngredienti().add(IngredienteDTO.buildIngredienteDTOFromModel(ingredienteItem, false, false));
			}
		}
		return result;
	}

	public static Pizza buildPizzaFromModelDTO(PizzaDTO input, boolean includeOdrini, boolean includeIngredienti) {
		Pizza result = new Pizza();
		result.setId(input.getId());
		result.setAttivo(input.isAttivo());
		result.setDescrizione(input.getDescrizione());
		result.setPrezzoBase(input.getPrezzoBase());
		result.setCodice(input.getCodice());
		if (includeOdrini) {
			for (OrdineDTO ordineDTOitem : input.getOrdini()) {
				result.getOrdini().add(OrdineDTO.buildOrdineFromDTO(ordineDTOitem, false, false));
			}
		}
		if (includeIngredienti) {
			for (IngredienteDTO ingredienteDTOItem : input.getIngredienti()) {
				result.getIngredienti().add(IngredienteDTO.buildIngredienteFromDTO(ingredienteDTOItem, false, false));
			}
		}
		return result;
	}

}
