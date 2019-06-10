package it.ordinearticolocategoria.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	private String descrizione;
	@ManyToMany(mappedBy = "categorie")
	private Set<Articolo> articoli=new HashSet<>(0);
	
	
	public Categoria() {}
	
	public Categoria (String descrizione) {
		this.descrizione=descrizione;
	}
	
	
	@Override
	public String toString() {
		return "Categoria [id=" + id + ", descrizione=" + descrizione + ", articoli=" + articoli + "]";
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
	public Set<Articolo> getArticoli() {
		return articoli;
	}
	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}
	public void aggiungiArticolo(Articolo articoloInput) {
		articoloInput.getCategorie().add(this);
		this.articoli.add(articoloInput);
		
	}
	
	public void rimuoviArticolo(Articolo articoloInput) {
		this.articoli.remove(articoloInput);
		articoloInput.getCategorie().remove(this);
	}
}
