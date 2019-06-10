package it.checkupprogetto.test;

import it.checkupprogetto.spring.MyServiceFactory;

public class Test {

	public static void main(String[] args) {
		MyServiceFactory.getCheckupService().checkupCompleto();
		MyServiceFactory.getCheckupService().getCardiologoService().controlloCardiologico();
	}

}
