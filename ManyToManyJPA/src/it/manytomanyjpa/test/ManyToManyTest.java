package it.manytomanyjpa.test;

import java.util.Date;

import it.manytomanyjpa.model.Ruolo;
import it.manytomanyjpa.model.Utente;
import it.manytomanyjpa.service.MyServiceFactory;
import it.manytomanyjpa.service.RuoloService;
import it.manytomanyjpa.service.UtenteService;

public class ManyToManyTest {

	public static void main(String[] args) {
		UtenteService utenteServiceInstance = MyServiceFactory.getUtenteServiceInstance();
		RuoloService ruoloServiceInstance = MyServiceFactory.getRuoloServiceInstance();

		// ora passo alle operazioni CRUD
		try {

			System.out.println("Elenca utenti: ");
			for (Utente utenteItem : utenteServiceInstance.listAll()) {
				System.out.println(utenteItem);
				System.out.println();
			}
			
			
			Utente utenteNuovo = new Utente ("Paolo89", "Paolo89","Paolo","Franceschi", new Date() );
			
			//utenteServiceInstance.inserisciNuovo(utenteNuovo);
			Utente utentedaCercare= new Utente();
			
			
			System.out.println("****** Ricerca ********");
			System.out.println(utenteServiceInstance.findByExample(utentedaCercare));
			for (Utente uteneItem : utenteServiceInstance.findAllByRuolo(ruoloServiceInstance.caricaSingoloElemento(2L))) {
				System.out.println(uteneItem);
				System.out.println();
			}
			
			//Ruolo ruoloNuovo = ruoloServiceInstance.caricaSingoloElemento(1L);
			//ruoloNuovo.setDescrizione("admin");
			//ruoloServiceInstance.aggiorna(ruoloNuovo);
//			ruoloServiceInstance.inserisciNuovo(ruoloNuovo);
			Ruolo ruoloNuovo2 = new Ruolo("Classic User","ROLE_CLASSIC_USER");
//			ruoloServiceInstance.inserisciNuovo(ruoloNuovo2);
			//ruoloServiceInstance.inserisciNuovo(ruoloNuovo2);
			//Ruolo ruoloDaDb = ruoloServiceInstance.caricaSingoloElemento(2L);
			//ruoloServiceInstance.rimuovi(ruoloServiceInstance.caricaSingoloElemento(3L));
			//Utente utenteDaDb = utenteServiceInstance.caricaSingoloElemento(3L);
			//if (utenteDaDb != null) {
			//	utenteDaDb.getRuoli().add(ruoloDaDb);
			//}
			
		//utenteServiceInstance.aggiorna(utenteDaDb);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}
