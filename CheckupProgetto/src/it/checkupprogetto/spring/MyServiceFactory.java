package it.checkupprogetto.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.checkupprogetto.service.CheckupService;

public class MyServiceFactory {
	private static ApplicationContext ctx;

	static {
		try {
			ctx = new ClassPathXmlApplicationContext("beans.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static CheckupService getCheckupService() {
		return (CheckupService) ctx.getBean("CheckupService");
	}
}
