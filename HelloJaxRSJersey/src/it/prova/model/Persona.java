package it.prova.model;

public class Persona {

	private Long id;
	private String nome;
	private String cognome;
	private Integer eta;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public Persona(Long id, String marca, String modello) {
		this.id = id;
		this.marca = marca;
		this.modello = modello;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModello() {
		return modello;
	}

	public void setModello(String modello) {
		this.modello = modello;
	}

}
