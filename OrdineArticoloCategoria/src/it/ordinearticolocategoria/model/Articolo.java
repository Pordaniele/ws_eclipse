package it.ordinearticolocategoria.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "articolo")
public class Articolo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	private String descrizione;
	private int prezzosingolo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn( nullable = false)
	private Ordine ordine;
	@ManyToMany
	@JoinTable(name = "articolo_categoria", joinColumns = @JoinColumn(name = "articolo_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "ID"))
	private Set<Categoria> categorie=new HashSet<>(0);

	public Articolo() {
	}
	
	public Articolo (String descrizione, int prezzosingolo) {
		this.descrizione=descrizione;
		this.prezzosingolo=prezzosingolo;
	}
	
	public Articolo (String descrizione, int prezzosingolo, Ordine ordine) {
		this.descrizione=descrizione;
		this.prezzosingolo=prezzosingolo;
		this.ordine=ordine;
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

	public int getPrezzosingolo() {
		return prezzosingolo;
	}

	public void setPrezzosingolo(int prezzosingolo) {
		this.prezzosingolo = prezzosingolo;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}
	
	
	
	@Override
	public String toString() {
		return "Articolo [id=" + id + ", descrizione=" + descrizione + ", prezzosingolo=" + prezzosingolo + "]";
	}
	
	
}
