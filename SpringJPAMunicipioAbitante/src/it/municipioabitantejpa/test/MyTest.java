package it.municipioabitantejpa.test;

import it.municipioabitantejpa.model.Municipio;
import it.municipioabitantejpa.service.BatteriaDiTestService;
import it.municipioabitantejpa.service.MyServiceFactory;
import it.municipioabitantejpa.service.municipio.MunicipioService;

import org.springframework.stereotype.Component;

@Component
public class MyTest {

	public static void main(String[] args) {

		// DA VALORIZZARE SECONDO I CASI ESPOSTI NELLE COSTANTI SOPRA
		// ##########################################################
		String casoDaTestare = BatteriaDiTestService.INSERISCI_NUOVO_MUNICIPIO;
		// ##########################################################

		System.out.println("################ START   #################");
		System.out.println("################ eseguo il test " + casoDaTestare
				+ "  #################");
 
		MyServiceFactory.getBatteriaDiTestServiceInstance().eseguiBatteriaDiTest(casoDaTestare);
		MyServiceFactory.getBatteriaDiTestServiceInstance().eseguiBatteriaDiTest(BatteriaDiTestService.INSERISCI_ABITANTI_DATO_UN_MUNICIPIO);
		
	
		System.out.println("################ FINE   #################");

	}
}
