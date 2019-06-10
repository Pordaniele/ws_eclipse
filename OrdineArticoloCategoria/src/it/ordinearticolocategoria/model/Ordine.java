package it.ordinearticolocategoria.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ordine")
public class Ordine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	private String nomedestinatario;
	private String indirizzospedizione;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ordine", orphanRemoval = true)
	private Set<Articolo> articoli=new HashSet<>(0);

	public Ordine() {
	}
	
	public Ordine (String nomedestinatario, String indirizzospedizione) {
		this.nomedestinatario=nomedestinatario;
		this.indirizzospedizione=indirizzospedizione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomedestinatario() {
		return nomedestinatario;
	}

	public void setNomedestinatario(String nomedestinatario) {
		this.nomedestinatario = nomedestinatario;
	}

	public String getIndirizzospedizione() {
		return indirizzospedizione;
	}

	public void setIndirizzospedizione(String indirizzospedizione) {
		this.indirizzospedizione = indirizzospedizione;
	}

	public Set<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}

	@Override
	public String toString() {
		return "Ordine [id=" + id + ", nomedestinatario=" + nomedestinatario + ", indirizzospedizione="
				+ indirizzospedizione + ", articoli=" + articoli + "]";
	}
	
	

}
