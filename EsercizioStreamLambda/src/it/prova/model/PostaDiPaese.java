package it.prova.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PostaDiPaese {
	private String denominazione;
	private String indirizzo;
	private Date data;
	private int numeroDipendenti;
	private List<Destinatario> destinatari = new ArrayList<>();

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getNumeroDipendenti() {
		return numeroDipendenti;
	}

	public void setNumeroDipendenti(int numeroDipendenti) {
		this.numeroDipendenti = numeroDipendenti;
	}

	public List<Destinatario> getDestinatari() {
		return destinatari;
	}

	public void setDestinatari(List<Destinatario> destinatari) {
		this.destinatari = destinatari;
	}

	public PostaDiPaese(String denominazione, String indirizzo, Date data, int numeroDipendenti) {
		super();
		this.denominazione = denominazione;
		this.indirizzo = indirizzo;
		this.data = data;
		this.numeroDipendenti = numeroDipendenti;
	}

	@Override
	public String toString() {
		return "PostaDiPaese [denominazione=" + denominazione + ", indirizzo=" + indirizzo + ", data=" + data
				+ ", numeroDipendenti=" + numeroDipendenti + "]";
	}
	

}
