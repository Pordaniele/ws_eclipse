package it.prova.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vino {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cantina;
	private Integer annata;
	private String localita;
	private String uva;

	public Vino(String nome, String cantina, String localita, String uva) {
		super();
		this.nome = nome;
		this.cantina = cantina;
		this.localita = localita;
		this.uva = uva;
	}

	public Vino(String nome, String cantina) {
		super();
		this.nome = nome;
		this.cantina = cantina;
	}

	public Vino(Long id, String nome, String cantina, Integer annata, String localita, String uva) {
		super();
		this.id = id;
		this.nome = nome;
		this.cantina = cantina;
		this.annata = annata;
		this.localita = localita;
		this.uva = uva;
	}

	public Vino() {
	}

	public Vino(String nome, String cantina, Integer annata, String localita, String uva) {
		super();
		this.nome = nome;
		this.cantina = cantina;
		this.annata = annata;
		this.localita = localita;
		this.uva = uva;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCantina() {
		return cantina;
	}

	public void setCantina(String cantina) {
		this.cantina = cantina;
	}

	public Integer getAnnata() {
		return annata;
	}

	public void setAnnata(Integer annata) {
		this.annata = annata;
	}

	public String getLocalita() {
		return localita;
	}

	public void setLocalita(String localita) {
		this.localita = localita;
	}

	public String getUva() {
		return uva;
	}

	public void setUva(String uva) {
		this.uva = uva;
	}

}
