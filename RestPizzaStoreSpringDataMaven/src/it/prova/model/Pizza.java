package it.prova.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descrizione;
	private String codice;
	private Double prezzoBase;
	private boolean attivo;
	@ManyToMany
	@JoinTable(name = "pizza_ingrediente", joinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ingrediente_id", referencedColumnName = "id"))
	Set<Ingrediente> ingredienti = new HashSet<>(0);
	@ManyToMany
	@JoinTable(name = "pizza_ordine", joinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "ordine_id", referencedColumnName = "id"))
	Set<Ordine> ordini=new HashSet<Ordine>(0);
	
	
	public Pizza() {
		super();
	}

	public Pizza(String descrizione, String codice, Double prezzoBase, boolean attivo) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
		this.prezzoBase = prezzoBase;
		this.attivo = attivo;
	}

	public Set<Ordine> getOrdini() {
		return ordini;
	}

	public void setOrdini(Set<Ordine> ordini) {
		this.ordini = ordini;
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

	public Set<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(Set<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

}
