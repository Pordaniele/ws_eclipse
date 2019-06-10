package it.prova.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
		AgenziaNoleggio cust = context.getBean(AgenziaNoleggio.class);
		PersonaGiuridica p1= new PersonaGiuridica();
		p1.setNome("ciro");
		cust.getCliente().setNome("Marco");
		cust.getCliente().ordina();
		cust.setCliente(p1);
		cust.getCliente().ordina();
	}

}
