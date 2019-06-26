package it.prova.model;

public class Persona {

	private Long id;
	private String nome;
	private String cognome;
	private Integer eta;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Persona(Long id, String nome, String cognome, Integer eta) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.eta=eta;
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getEta() {
		return eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	
}
