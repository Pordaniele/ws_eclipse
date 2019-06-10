package it.prova;

import it.prova.service.ImpresaRistrutturazioneService;
import it.prova.spring.MyServiceFactory;

public class Test {

	public static void main(String[] args) {
		MyServiceFactory.getImpresaRistrutturazioneService()
				.ristrutturaAppartamento();
			System.out.println("Prova con metodo diverso ");
		MyServiceFactory.getImpresaRistrutturazioneService().soloUnaCosa();
		MyServiceFactory.getImbianchinoService().imbianca();
	}

}
