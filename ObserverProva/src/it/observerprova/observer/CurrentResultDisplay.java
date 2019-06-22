package it.observerprova.observer;

import it.observerprova.subject.Subject;

public class CurrentResultDisplay implements Observer, DisplayElement {
	private String match;
	private String risultatoCorrente;
	private String marcatore;
	private Subject risultati;
	public String getMatch() {
		return match;
	}
	public void setMatch(String match) {
		this.match = match;
	}
	public String getRisultato() {
		return risultatoCorrente;
	}
	public void setRisultato(String risultatoCorrente) {
		this.risultatoCorrente = risultatoCorrente;
	}
	public String getMarcatore() {
		return marcatore;
	}
	public void setMarcatore(String marcatore) {
		this.marcatore = marcatore;
	}
	public Subject getRisultati() {
		return risultati;
	}
	public void setRisultati(Subject risultati) {
		this.risultati = risultati;
	}
	
	public CurrentResultDisplay (Subject risultati) {
		this.risultati=risultati;
		risultati.registerObserver(this);
		
	}
	@Override
	public void display() {
		System.out.println("Match: "+match+" il risultato è: "+ risultatoCorrente+ " il marcatore è: " + marcatore );
		
	}
	@Override
	public void update(String match, String risultatoCorrente, String marcatore) {
		this.marcatore=marcatore;
		this.match=match;
		this.risultatoCorrente=risultatoCorrente;
		display();
		
	}
}
