package it.prova.annotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext context = 
		    	  new ClassPathXmlApplicationContext(new String[] {"beans.xml"});
		 
		    	AgenziaNoleggio cust = context.getBean(AgenziaNoleggio.class);
		    	
		    	PersonaFisica pg = context.getBean(PersonaFisica.class);
		    	PersonaGiuridica cc= context.getBean(PersonaGiuridica.class);
		    	pg.setNome("Pluto");
		    	cc.setNome("pippo");
		    	cust.getCliente().ordina();
		    	cust.setCliente(pg);
		    	cust.getCliente().ordina();

		    	cust.setCliente(cc);
		    	cust.getCliente().ordina();

	}
	    	
}
