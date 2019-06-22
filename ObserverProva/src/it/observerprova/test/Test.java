package it.observerprova.test;

import it.observerprova.observer.CurrentResultDisplay;
import it.observerprova.subject.Risultati;

public class Test {

	public static void main(String[] args) {
		Risultati risultatoGiornata3= new Risultati();
		CurrentResultDisplay currentResultDisplay= new CurrentResultDisplay(risultatoGiornata3);
		risultatoGiornata3.setRisultato("Roma-Lazio", "0-0", "Nessuno");
		risultatoGiornata3.setRisultato("Roma-Lazio", "1-0", "Totti");
	}

}
