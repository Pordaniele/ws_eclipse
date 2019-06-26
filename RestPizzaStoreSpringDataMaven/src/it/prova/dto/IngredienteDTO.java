package it.prova.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import it.prova.model.Ingrediente;
import it.prova.model.Pizza;

public class IngredienteDTO {
	private Long id;
	private String descrizione;
	private String codice;
	private Double prezzo;
	@JsonIgnoreProperties(value= {"ingredienti"})
	private Set<PizzaDTO> pizze= new HashSet<>(0);
	
	public IngredienteDTO(Long id, String descrizione, String codice, Double prezzo, Set<PizzaDTO> pizze) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
		this.prezzo = prezzo;
		this.pizze = pizze;
	}
	
	public IngredienteDTO() {}

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

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}

	public Set<PizzaDTO> getPizze() {
		return pizze;
	}

	public void setPizze(Set<PizzaDTO> pizze) {
		this.pizze = pizze;
	}
	
	public static IngredienteDTO buildIngredienteDTOFromModel(Ingrediente input, boolean includePizza, boolean includeOrdine) {
		IngredienteDTO result = new IngredienteDTO();
		result.setCodice(input.getCodice());
		result.setDescrizione(input.getDescrizione());
		result.setId(input.getId());
		result.setPrezzo(input.getPrezzo());
		if(includePizza){
			for (Pizza pizzaItem : input.getPizze()) {
				result.getPizze().add(PizzaDTO.buildPizzaDTOFromModel(pizzaItem, includeOrdine, false));
			}
		}
		return result;
		
	}
	
	public static Ingrediente buildIngredienteFromDTO (IngredienteDTO input, boolean includePizza, boolean includeOrdine) {
		Ingrediente result = new Ingrediente();
		result.setCodice(input.getCodice());
		result.setDescrizione(input.getDescrizione());
		result.setId(input.getId());
		result.setPrezzo(input.getPrezzo());
		if(includePizza){
			for (PizzaDTO pizzaItem : input.getPizze()) {
				result.getPizze().add(PizzaDTO.buildPizzaFromModelDTO(pizzaItem, includeOrdine, false));
			}
		}
		return result;
	}
}
