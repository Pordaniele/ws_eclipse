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
public class Ingrediente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
private String descrizione;
private String codice;
private Double prezzo;
@ManyToMany
@JoinTable(name = "pizza_ingrediente", joinColumns = @JoinColumn(name = "ingrediente_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pizza_id", referencedColumnName = "id"))
private Set<Pizza> pizze= new HashSet<>(0);



public Ingrediente(String descrizione, String codice, Double prezzo) {
	super();
	this.descrizione = descrizione;
	this.codice = codice;
	this.prezzo = prezzo;
}

public Set<Pizza> getPizze() {
	return pizze;
}

public void setPizze(Set<Pizza> pizze) {
	this.pizze = pizze;
}

public Ingrediente() {
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
public Double getPrezzo() {
	return prezzo;
}
public void setPrezzo(Double prezzo) {
	this.prezzo = prezzo;
}



}
