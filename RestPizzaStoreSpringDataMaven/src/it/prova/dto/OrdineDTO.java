package it.prova.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import it.prova.model.Ordine;
import it.prova.model.Pizza;

public class OrdineDTO {
	private Long id;
	private Date dataOrdine;
	private boolean closed;
	private String codice;
	private Double totaleOrdine;
	private ClienteDTO cliente;
	@JsonIgnoreProperties(value = { "ordini" })
	private List<PizzaDTO> pizze= new ArrayList<>();
	private UtenteDTO fattorino;
	
	public OrdineDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataOrdine() {
		return dataOrdine;
	}
	public void setDataOrdine(Date dataOrdine) {
		this.dataOrdine = dataOrdine;
	}
	public boolean isClosed() {
		return closed;
	}
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public Double getTotaleOrdine() {
		return totaleOrdine;
	}
	public void setTotaleOrdine(Double totaleOrdine) {
		this.totaleOrdine = totaleOrdine;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public List<PizzaDTO> getPizze() {
		return pizze;
	}
	public void setPizze(List<PizzaDTO> pizze) {
		this.pizze = pizze;
	}
	public UtenteDTO getFattorino() {
		return fattorino;
	}
	public void setFattorino(UtenteDTO fattorino) {
		this.fattorino = fattorino;
	}
public static OrdineDTO buildOrdineDTOFromModel(Ordine input, boolean includePizza, boolean includeIngredienti) {
	OrdineDTO result = new OrdineDTO();
	result.setTotaleOrdine(input.getTotaleOrdine());
	result.setClosed(input.isClosed());
	if (input.getCliente()!=null) {
	result.setCliente(ClienteDTO.buildClienteDTOFromModel(input.getCliente(), false, false, false));
	}else input.setCliente(null);
	if(input.getFattorino()!=null) {
	result.setFattorino(UtenteDTO.buildUtenteDTOFromModel(input.getFattorino()));
	} else input.setFattorino(null);
	result.setDataOrdine(input.getDataOrdine());
	result.setId(input.getId());
	
	if(includePizza) {
		for (Pizza pizzaItem: input.getPizze())
			result.getPizze().add(PizzaDTO.buildPizzaDTOFromModel(pizzaItem, false, includeIngredienti));
	}
	return result;
	
}

public static Ordine buildOrdineFromDTO(OrdineDTO input, boolean includePizza, boolean includeIngredienti) {
	Ordine result = new Ordine();
	result.setTotaleOrdine(input.getTotaleOrdine());
	result.setClosed(input.isClosed());
	if (input.getCliente()!=null) {
	result.setCliente(ClienteDTO.buildClienteFromDTO(input.getCliente(), false, false, false));
	}else input.setCliente(null);
	if(input.getFattorino()!=null) {
	result.setFattorino(UtenteDTO.buildUtenteFromUtenteDTO(input.getFattorino()));
	} else input.setFattorino(null);
	result.setDataOrdine(input.getDataOrdine());
	result.setId(input.getId());
	if(includePizza) {
		for (PizzaDTO pizzaItem: input.getPizze())
			result.getPizze().add(PizzaDTO.buildPizzaFromModelDTO(pizzaItem, false, includeIngredienti));
	}
	return result;
}
}
