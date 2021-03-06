package it.concessionariomoto.serviceo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.concessionariomoto.model.Concessionario;
import it.concessionariomoto.model.Motociclo;
import it.concessionariomoto.service.concessionario.ConcessionarioService;
import it.concessionariomoto.service.motociclo.MotocicloService;

@Component
public class BatteriaDiTestService {

	@Autowired
	private MotocicloService motocicloService;

	@Autowired
	private ConcessionarioService concessionarioService;

	// casi di test (usare valorizzando la variabile casoDaTestare nel main)
	public static final String INSERISCI_NUOVO_CONCESSIONARIO = "INSERISCI_NUOVO_CONCESSIONARIO";
	public static final String INSERISCI_MOTO_DATO_UN_CONCESSIONARIO = "INSERISCI_MOTO_DATO_UN_CONCESSIONARIO";
	public static final String RIMUOVI_CONCESSIONARIO_E_MOTO = "RIMUOVI_CONCESSIONARIO_E_MOTO";
	public static final String ELENCA_TUTTI_I_CONCESSIONARI = "ELENCA_TUTTI_I_CONCESSIONARI";
	public static final String FIND_BY_EXAMPLE_BY_CITTA = "FIND_BY_EXAMPLE_BY_CITTA";
	public static final String UPDATE_MOTO_SET_CILINDRATA = "UPDATE_MOTO_SET_CILINDRATA";
	public static final String CARICA_CONCESSIONARIO_EAGER = "CARICA_MUNICIPIO_EAGER";
	public static final String CERCA_CONCESSIONARIA_CILINDRATA1200 = "CERCA_CONCESSIONARIA_CILINDRATA1200";
	public static final String NUMEROTOTALEMOTOIMMATRICOLATETORINOPRIMA2010 = "NUMEROTOTALEMOTOIMMATRICOLATETORINOPRIMA2010";
	public static final String LISTAPARTITAIVAORDINATAHONDAMILANO20122016 = "LISTAPARTITAIVAORDINATAHONDAMILANO20122016";
	public static final String ELENCA_TUTTE_LE_MOTO = "ELENCA_TUTTE_LE_MOTO";
	public static final String CASOCUSTOM="CASOCUSTOM";
	public void eseguiBatteriaDiTest(String casoDaTestare) {
		try {
			
			switch (casoDaTestare) {
			
			case CASOCUSTOM:
				Concessionario nuovoConcessionari=new Concessionario("Auto2" , "torino", "weqwe");
				Motociclo nuovaMoto = new Motociclo("Honda", "ciao", 1200, 2010);
				
				System.out.println("print");
				concessionarioService.refresh(nuovoConcessionari);
				
				
				nuovaMoto.setConcessionario(nuovoConcessionari);
				
				motocicloService.refresh(nuovaMoto);
				System.out.println("refreshato");
				
			
				break;
				
			case INSERISCI_NUOVO_CONCESSIONARIO:
				// creo nuovo municipio
				Concessionario nuovoConcessionario = new Concessionario("AutoFiori", "Roma", "92380192380");
				// salvo
				concessionarioService.inserisciNuovo(nuovoConcessionario);
				System.out.println("Concessionario appena inserito: " + nuovoConcessionario);
				break;
			case INSERISCI_MOTO_DATO_UN_CONCESSIONARIO:
				// / creo nuovo abitante
				Motociclo nuovoMotociclo = new Motociclo("Honda", "BO", 1500, 2016);
				nuovoMotociclo.setConcessionario(concessionarioService.caricaSingoloConcessionario(2L));
				// salvo
				motocicloService.inserisciNuovo(nuovoMotociclo);
				break;
			case ELENCA_TUTTI_I_CONCESSIONARI:
				// elencare i municipi
				System.out.println("Elenco i concessionari:");
				for (Concessionario concessionarioItem : concessionarioService.listAllMunicipi()) {
					System.out.println(concessionarioItem);
				}
				break;
			case ELENCA_TUTTE_LE_MOTO:
				// elencare i municipi
				System.out.println("Elenco le moto:");
				for (Motociclo motoItem : motocicloService.listAllMoto()) {
					System.out.println(motoItem);
				}
				break;
			case RIMUOVI_CONCESSIONARIO_E_MOTO:
				// per cancellare tutto il municipio
				concessionarioService.rimuovi(concessionarioService.caricaSingoloConcessionario(2L));
				break;
			case FIND_BY_EXAMPLE_BY_CITTA:
				System.out.println("########### EXAMPLE ########################");
				// find by example: voglio ricercare i municipi con
				// ubicazione'Via dei Grandi'
				Concessionario concessionarioExample = new Concessionario();
				concessionarioExample.setCitta("roma");
				for (Concessionario concessionarioItem : concessionarioService.findByExample(concessionarioExample)) {
					System.out.println(concessionarioItem);
				}
				break;
			case UPDATE_MOTO_SET_CILINDRATA:
				// carico un abitante e cambio eta
				Motociclo motoEsistente = motocicloService.caricaSingoloMoto(14L);
				if (motoEsistente != null) {
					motoEsistente.setCilindrata(50);
					motocicloService.aggiorna(motoEsistente);
				}
				break;
			case CARICA_CONCESSIONARIO_EAGER:
				// quando carico un Municipio ho già i suoi abitanti
				Concessionario concessionarioACaso = concessionarioService.caricaSingoloConcessionarioEagerMoto(23L);

				if (concessionarioACaso != null) {
					for (Motociclo motoItem : concessionarioACaso.getMotocicli()) {
						System.out.println(motoItem);
					}
				}
				break;
			case LISTAPARTITAIVAORDINATAHONDAMILANO20122016:
				for (Concessionario concessionarioItem : concessionarioService
						.listaOrdinataConcessionariMilanoCheHannoHondaImmatricolata20122016()) {
					System.out.println(concessionarioItem.getPartitaIva());
				}
				break;
			case CERCA_CONCESSIONARIA_CILINDRATA1200:
				// elencare i municipi
				System.out.println("Elenco i municipi:");
				for (Concessionario concessionarioItem : concessionarioService.cercaConcessionariMoto1200Ordinati()) {
					System.out.println(concessionarioItem);
				}
				break;
			case NUMEROTOTALEMOTOIMMATRICOLATETORINOPRIMA2010:
				// per cancellare tutto il municipio
				System.out.println(motocicloService.numeroMotoATorinoPrima2010());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
