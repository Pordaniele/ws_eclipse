package it.prova.spring;

import it.prova.dao.StudenteDAO;
import it.prova.service.EsameService;
import it.prova.service.ProfessoreItalianoService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyServiceFactory {

	private static ApplicationContext ctx;

	static {
		try {
			ctx  = new AnnotationConfigApplicationContext(AppConfig.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static EsameService getEsameService() {
		return  ctx.getBean(EsameService.class);
	}
	public static StudenteDAO getStudenteDAO() {
		return ctx.getBean(StudenteDAO.class);
	}
	public static ProfessoreItalianoService getProfessoreIta() {
		return ctx.getBean(ProfessoreItalianoService.class);
	}
}
