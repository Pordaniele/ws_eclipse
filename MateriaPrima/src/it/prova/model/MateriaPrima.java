package it.prova.model;

public class MateriaPrima {

	private int id;
	private String descrizione;
	private StatoMateria stato;

	public MateriaPrima() {
		this.stato = StatoMateria.IN_INSERIMENTO;
	}

	public MateriaPrima(int id, String descrizione) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.stato = StatoMateria.IN_INSERIMENTO;

	}

	public StatoMateria getStato() {
		return stato;
	}

	public void setStato(StatoMateria stato) {
		this.stato = stato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	@Override
	public String toString() {
		return "MateriaPrima [id=" + id + ", descrizione=" + descrizione + ", stato=" + stato + "]";
	}

}
