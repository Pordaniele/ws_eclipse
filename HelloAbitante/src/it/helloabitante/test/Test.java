package it.helloabitante.test;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Abitante a1=new Abitante();
		a1.setNome("mengoni");
System.out.println(MyServiceFactory.getAbitanteServiceInstance().rimuoviAbitante(MyServiceFactory.getAbitanteServiceInstance().get(3L))); 
	}

}
