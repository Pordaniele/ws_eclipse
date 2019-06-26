package it.prova.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Ordine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Date dataOrdine;
	private boolean closed;
	private String codice;
	private Double totaleOrdine;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	@ManyToMany
	@JoinTable(name = "pizza_ordine", joinColumns = @JoinColumn(name = "ordine_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
	private List<Pizza> pizze= new ArrayList<>();
	@ManyToOne
	@JoinColumn(name = "utente_id")
	private Utente fattorino;
	
	
	
	public Ordine() {
		super();
	}
	public Ordine(Date dataOrdine, boolean closed, String codice, Double totaleOrdine, Cliente cliente,
			List<Pizza> pizze, Utente fattorino) {
		super();
		this.dataOrdine = dataOrdine;
		this.closed = closed;
		this.codice = codice;
		this.totaleOrdine = totaleOrdine;
		this.cliente = cliente;
		this.pizze = pizze;
		this.fattorino = fattorino;
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
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Pizza> getPizze() {
		return pizze;
	}
	public void setPizze(List<Pizza> pizze) {
		this.pizze = pizze;
	}
	public Utente getFattorino() {
		return fattorino;
	}
	public void setFattorino(Utente fattorino) {
		this.fattorino = fattorino;
	}
	
	
	
}
