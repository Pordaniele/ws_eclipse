package it.concessionariomoto.test;

import it.concessionariomoto.serviceo.MyServiceFactory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String casoDaTestare = it.concessionariomoto.serviceo.BatteriaDiTestService.CASOCUSTOM;
		MyServiceFactory.getBatteriaDiTestServiceInstance().eseguiBatteriaDiTest(casoDaTestare);
		
		
	}

}
