package it.observerprova.subject;

import java.util.ArrayList;

import it.observerprova.observer.Observer;

public class Risultati implements Subject{
private ArrayList<Observer> observers;

private String match;
private String risultato;
private String marcatore;

public Risultati() {
	observers = new ArrayList<>();
}

@Override
public void registerObserver(Observer o) {
	observers.add(o);
	
}

@Override
public void removeObserver(Observer o) {
	int i = observers.indexOf(o);
	if (i >= 0) {
		observers.remove(i);
	}
}

@Override
public void notifyObservers() {
	for (Observer observerItem : observers) 
		observerItem.update(match, risultato, marcatore);
}

public void cambioRisultato() {
	notifyObservers();
}

public void setRisultato (String match, String risultato, String marcatore) {
this.match=match;
this.marcatore=marcatore;
this.risultato=risultato;
cambioRisultato();
}
}
