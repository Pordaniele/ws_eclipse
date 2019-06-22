package it.prova.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import it.prova.mock.Mock;
import it.prova.model.Destinatario;
import it.prova.model.PostaDiPaese;

public class Test {

	public static void main(String[] args) {
		List<PostaDiPaese> listaPoste = Mock.POSTE_LIST;
		// Esercizio 1
		// tutte le poste il cui indirizzo contenga (mi)
		System.out.println("le poste il cuo indirizzo contenga (mi)");
		List<PostaDiPaese> listaPosteMilano = listaPoste.stream().filter(item -> item.getIndirizzo().contains("(mi)"))
				.collect(Collectors.toList());

		// la stampo
		listaPosteMilano.forEach(item -> System.out.println(item));

		System.out.println("***********************************************");

		// Esercizio 2
		// tutte le poste aperte dopo marzo 2019

		System.out.println("tutte le poste aperte dopo primo marzo 2019");
		Date dataMarzo;
		try {
			dataMarzo = new SimpleDateFormat("dd/MM/yyyy").parse("01/03/2019");
			List<PostaDiPaese> listaPosteDopoMarzo2019 = listaPoste.stream()
					.filter(item -> item.getData().after(dataMarzo)).collect(Collectors.toList());
			listaPosteDopoMarzo2019.forEach(item -> System.out.println(item));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("***********************************************");

		// Esercizio 3
		// Lista di indirizzi poste il cui numero dipendenti sia superiore a 20
		System.out.println("Lista di indirizzi poste il cui numero dipendenti sia superiore a 20");
		List<String> listaIndirizzi = listaPoste.stream().filter(item -> item.getNumeroDipendenti() > 20)
				.collect(Collectors.toList()).stream().map(item2 -> item2.getIndirizzo()).collect(Collectors.toList());

		listaIndirizzi.forEach(item -> System.out.println(item));

		System.out.println("***********************************************");

		// Esercizio 4
		// Lista inidirizzi di poste con almeno 10 dipendenti
		System.out.println("Lista di indirizzi di poste con almeno 10");
		List<String> listaIndirizziDestinatarialmeno10 = listaPoste.stream()
				.filter(item -> item.getNumeroDipendenti() >= 10).collect(Collectors.toList()).stream()
				.flatMap(x -> x.getDestinatari().stream())
				.map(item -> item.getIndirizzo()).collect(Collectors.toList());
		listaIndirizziDestinatarialmeno10.forEach(item-> System.out.println(item));
		

		
		System.out.println("***********************************************");

		
		//Esercizio 5
		//Lista indirizzi di destinatari con conto ma appartenenti a poste con dipendenti tra 50 e 100
		System.out.println("Lista indirizzi di destinatari con conto ma appartenenti a poste con dipendenti tra 50 e 100");
		List<Destinatario> listaDestinatariConDipendenti100o50 = listaPoste.stream().filter(item-> item.getNumeroDipendenti()>50 && item.getNumeroDipendenti()<100).collect(Collectors.toList())
				.stream().flatMap(item->item.getDestinatari().stream()).filter(item-> item.isPossessoreContoCorrente()==true).collect(Collectors.toList());
		listaDestinatariConDipendenti100o50.forEach(item-> System.out.println(item));
		
		//Esercizio 6
		//Lista indirizzi destinatari poste che hanno nel campo il campo "centrale" e siano aperte almeno a gennario 2000
		System.out.println("Lista indirizzi destinatari poste che hanno nel campo il campo centrale e siano aperte almeno a gennario 2000");
		
		Date dataGennaio2000;
		try {
			dataGennaio2000 = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2000");
			List<Integer> listaeta = listaPoste.stream()
					.filter(item -> item.getData().after(dataGennaio2000)&& item.getDenominazione().contains("centrale")).collect(Collectors.toList()).stream().flatMap(item-> item.getDestinatari().stream()).collect(Collectors.toList()).stream().map(item->item.getEta()).collect(Collectors.toList());
			
			listaeta.forEach(item-> System.out.println(item));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		
		}
	}
	

}
