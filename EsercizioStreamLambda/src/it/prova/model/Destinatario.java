package it.prova.model;

public class Destinatario {
	private String nome;
	private String cognome;
	private int eta;
	private String indirizzo;
	private boolean possessoreContoCorrente;
	private PostaDiPaese postaDiPaese;

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

	public int getEta() {
		return eta;
	}

	public void setEta(int eta) {
		this.eta = eta;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public boolean isPossessoreContoCorrente() {
		return possessoreContoCorrente;
	}

	public void setPossessoreContoCorrente(boolean possessoreContoCorrente) {
		this.possessoreContoCorrente = possessoreContoCorrente;
	}

	public PostaDiPaese getPostaDiPaese() {
		return postaDiPaese;
	}

	public void setPostaDiPaese(PostaDiPaese postaDiPaese) {
		this.postaDiPaese = postaDiPaese;
	}

	public Destinatario(String nome, String cognome, int eta, String indirizzo, boolean possessoreContoCorrente,
			PostaDiPaese postaDiPaese) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.indirizzo = indirizzo;
		this.possessoreContoCorrente = possessoreContoCorrente;
		this.postaDiPaese = postaDiPaese;
	}

	public Destinatario(String nome, String cognome, int eta, String indirizzo, boolean possessoreContoCorrente) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.indirizzo = indirizzo;
		this.possessoreContoCorrente = possessoreContoCorrente;
	}

	@Override
	public String toString() {
		return "Destinatario [nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", indirizzo=" + indirizzo
				+ ", possessoreContoCorrente=" + possessoreContoCorrente + "]";
	}

}
