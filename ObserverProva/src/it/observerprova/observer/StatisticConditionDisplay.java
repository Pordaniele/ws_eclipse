//package it.observerprova.observer;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import it.observerprova.subject.Subject;
//
//public class StatisticConditionDisplay implements Observer, DisplayElement {
//
//	private String match;
//	private String risultatoCorrente;
//	private String marcatore;
//	private Subject risultati;
//	private List<String> classificaGol=new ArrayList<>();
//	public StatisticConditionDisplay(Subject risultati) {
//		this.risultati= risultati;
//		risultati.registerObserver(this);
//	}
//	
//
//
//	public String getMatch() {
//		return match;
//	}
//
//
//
//	public void setMatch(String match) {
//		this.match = match;
//	}
//
//
//
//	public String getRisultatoCorrente() {
//		return risultatoCorrente;
//	}
//
//
//
//	public void setRisultatoCorrente(String risultatoCorrente) {
//		this.risultatoCorrente = risultatoCorrente;
//	}
//
//
//
//	public String getMarcatore() {
//		return marcatore;
//	}
//
//
//
//	public void setMarcatore(String marcatore) {
//		this.marcatore = marcatore;
//	}
//
//
//
//	public Subject getRisultati() {
//		return risultati;
//	}
//
//
//
//	public void setRisultati(Subject risultati) {
//		this.risultati = risultati;
//	}
//
//
//
//	public List<String> getClassificaGol() {
//		return classificaGol;
//	}
//
//
//
//	public void setClassificaGol(List<String> classificaGol) {
//		this.classificaGol = classificaGol;
//	}
//
//
//
//	@Override
//	public void display() {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//	@Override
//	public void update(String match, String risultato, String marcatore) {
//     int conta=0;
//		for (String item : classificaGol) {
//			if(item.equals(marcatore)) {
//				conta++;
//			}
//					
//		}
//		
//	}
//
//
//
//	
//}
